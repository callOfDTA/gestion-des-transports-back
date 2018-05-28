package dev.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.entite.Annonce;
import dev.entite.Personne;
import dev.repository.AnnonceRepository;

@RestController
@CrossOrigin
@RequestMapping("/annonces")
public class AnnonceController {

	@Autowired
	private AnnonceRepository annonceRepo;

	List<Personne> passagers;

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
}
