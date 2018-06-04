package dev;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.entite.Adresse;
import dev.entite.Annonce;
import dev.entite.CategorieVehicule;
import dev.entite.Personne;
import dev.entite.ReservationVehicule;
import dev.entite.Role;
import dev.entite.StatusVehicule;
import dev.entite.Vehicule;
import dev.repository.AnnonceRepository;
import dev.repository.PersonneRepository;
import dev.repository.ReservationVehiculeRepository;
import dev.repository.VehiculeRepository;

@Component
public class StartupDataInit {

	@Autowired
	AnnonceRepository annonceRepo;

	@Autowired
	VehiculeRepository vehiculeRepo;
	@Autowired
	PersonneRepository personneRepo;
	@Autowired
	ReservationVehiculeRepository reservationRepo;

	@EventListener(ContextRefreshedEvent.class)
	public void init() {
		Vehicule v1 = new Vehicule("111-eee-222", "Ferrari", "f1", 2,
				"https://auto.ferrari.com/fr_FR/wp-content/uploads/sites/13/2017/02/Ferrari_812_slider-1260x570.jpg",
				StatusVehicule.EN_SERVICE, CategorieVehicule.COMPACTES);
		Vehicule v2 = new Vehicule("222-zzz-333", "Smart", "mini", 1,
				"https://www.smart.com/content/smart/fr/website/fr/teaser-library/smart-fortwo-cabrio-453/smart-brabus-cabrio-tailor-made/_jcr_content/teaser.imgresize.width=320.jpg/1461043909147.jpg",
				StatusVehicule.REPARATION, CategorieVehicule.MICRO_URBAINE);
		Vehicule v3 = new Vehicule("123-ABC-456", "volkswagen", "vane", 10,
				"https://www.google.fr/search?q=vanne+voiture&source=lnms&tbm=isch&sa=X&ved=0ahUKEwisyqaJhp7bAhUJPhQKHcgcBckQ_AUICigB&biw=1920&bih=974#imgrc=ZkK8pO-i1ObgoM:",
				StatusVehicule.EN_SERVICE, CategorieVehicule.BERLINE_L);

		Personne p1 = new Personne("4321", "Collabo", "Jean", Role.COLLABORATEUR, "jj.collabo@email.fr", "1234",
				"https://vignette.wikia.nocookie.net/desencyclopedie/images/7/7e/Personne11.jpg/revision/latest/scale-to-width-down/300?cb=20101218132811");
		Personne p2 = new Personne("1234", "Chauffeur", "Jean", Role.CHAUFFEUR, "jj.chauffeur@email.fr", "1234",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShN2VahpweEy_6Jo3uPlZuYWdhzqYHmUj8trC2M_IdUlinq2DX");
		Personne p3 = new Personne("2143", "Admin", "Jean", Role.ADMINISTRATEUR, "jj.admin@email.fr", "1234",
				"https://static.ladepeche.fr/content/media/image/zoom/2015/08/27/2134218-focus.jpg");

		Annonce a1 = new Annonce(v1, LocalDateTime.now(), new Adresse("rue 1", 12345, "SuperVille"),
				new Adresse("rue 34", 54321, "VilleMoinsBien"), LocalTime.of(2, 45), Double.valueOf(258), p1,
				v1.getNbPlace());
		Annonce a2 = new Annonce(v3, LocalDateTime.now(), new Adresse("rue 18", 12345, "SuperVille"),
				new Adresse("rue 4", 54321, "VilleMoinsBien"), LocalTime.of(2, 15), Double.valueOf(240), p2,
				v3.getNbPlace());
		Annonce a3 = new Annonce(v2, LocalDateTime.of(2018, 07, 14, 9, 20), new Adresse("rue 42", 12345, "BouzeVille"),
				new Adresse("rue 5", 54321, "VilleDeClochard"), LocalTime.of(1, 15), Double.valueOf(110), p3,
				v2.getNbPlace());

		ReservationVehicule rv1 = new ReservationVehicule(LocalDateTime.now(), LocalDateTime.of(2018, 05, 25, 8, 50),
				true, v1, p2, p3);

		List<Personne> l = new ArrayList<Personne>();
		l.add(p3);
		l.add(p2);
		a1.setPassagers(l);
		a1.setPlaceDispo(a1.getPlaceDispo() - 2);
		if (this.annonceRepo.count() <= 0) {

			personneRepo.save(p1);
			personneRepo.save(p2);
			personneRepo.save(p3);
			vehiculeRepo.save(v1);
			vehiculeRepo.save(v2);
			vehiculeRepo.save(v3);
			annonceRepo.save(a1);
			annonceRepo.save(a2);
			annonceRepo.save(a3);
			reservationRepo.save(rv1);
		}

	}
}
