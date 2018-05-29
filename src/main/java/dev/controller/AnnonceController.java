package dev.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dev.controller.viewmodel.ReservationCovoiturageVM;
import dev.entite.Annonce;
import dev.entite.Personne;
import dev.entite.Vehicule;
import dev.repository.AnnonceRepository;
import dev.repository.PersonneRepository;
import dev.repository.VehiculeRepository;

@RestController
@CrossOrigin
@RequestMapping("/annonces")
public class AnnonceController {

	private static final String URI_COL = "http://app-3d0a5967-9429-444f-907d-cd29c4ee0f0c.cleverapps.io/collegues";

	@Autowired
	private AnnonceRepository annonceRepo;

	@Autowired
	private PersonneRepository personneRepo;

	@Autowired
	private VehiculeRepository vehiculeRepo;

	/**
	 * 
	 * @return la liste de toutes les annonces de covoiturage
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(this.annonceRepo.findAll());
	}

	/**
	 * 
	 * @param matricule
	 *            du conducteur
	 * @return la liste des annonce de covoiturage publier par le conducteur
	 */
	@RequestMapping(value = "{matricule}", method = RequestMethod.GET)
	public ResponseEntity<?> findAnnonceByMatricule(@PathVariable("matricule") String matricule) {
		List<Annonce> la = this.annonceRepo.findAll();
		la = la.stream().filter(annonce -> annonce.getConducteur().getMatricule().equals(matricule))
				.collect(Collectors.toList());
		return ResponseEntity.ok(la);
	}

	/**
	 * 
	 * @param matricule
	 *            de la personne dont on souhaite recupérer les resevation de
	 *            covoiturage effectuer
	 * @return la listes des annonces reserver par la Personne demandé
	 */
	@RequestMapping(value = "/passager/{matricule}", method = RequestMethod.GET)
	public ResponseEntity<?> getReservationByMatricule(@PathVariable("matricule") String matricule) {
		List<Annonce> la = this.annonceRepo.findAll();
		System.out.println(matricule);
		la = la.stream().filter(annonce -> {
			List<Personne> passagers = annonce.getPassagers();
			return passagers.stream().anyMatch(passager -> passager.getMatricule().equals(matricule));
		}).collect(Collectors.toList());
		return ResponseEntity.ok(la);
	}

	/**
	 * 
	 * @param data
	 *            : contient l'ID de l'annonce souhaitant être reserver ainsi
	 *            que le matricule du passager effectuant la reservation
	 * @return l'annonce actualiser avec le nouveau Passager
	 */
	@RequestMapping(value = "/passager", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> reservationByMatricule(@RequestBody ReservationCovoiturageVM data) {
		RestTemplate restTemplate = new RestTemplate();

		Personne nouveauPassager = this.personneRepo.findByMatricule(data.getPassagerMatricule());
		if (nouveauPassager == null) {
			Personne[] tab = restTemplate.getForObject(URI_COL + "?matricule=" + data.getPassagerMatricule(),
					Personne[].class);

			if (tab.length == 0) {
				return ResponseEntity.badRequest().body("Le matricule spécifié n'a pas été trouvé");
			}
			nouveauPassager = tab[0];
			personneRepo.save(nouveauPassager);
		}

		Annonce annonce = annonceRepo.findById(data.getAnnonceID());
		if (annonce.getPlaceDispo() == 0) {
			return ResponseEntity.badRequest().body("Ce covoiturage est complet!");
		}
		List<Personne> passagers = annonce.getPassagers();
		passagers.add(nouveauPassager);
		annonce.setPassagers(passagers);
		annonce.setPlaceDispo(annonce.getPlaceDispo() - 1);
		annonceRepo.save(annonce);
		return ResponseEntity.ok(annonce);

	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> creerAnnonce(@RequestBody Annonce annonce) {
		Vehicule v = annonce.getVehicule();
		Vehicule v2;

		personneRepo.save(annonce.getConducteur());

		if ((v2 = vehiculeRepo.findByImmatriculation(v.getImmatriculation())) != null)
			v.setId(v2.getId());
		vehiculeRepo.save(v);
		annonce.getPassagers().stream().forEach(p -> personneRepo.save(p));
		annonceRepo.save(annonce);
		return ResponseEntity.ok(annonce);
	}

}
