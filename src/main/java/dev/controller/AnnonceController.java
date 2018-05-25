package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.entite.Annonce;
import dev.repository.AnnonceRepository;

@RestController
@CrossOrigin
@RequestMapping("/annonces")
public class AnnonceController {

	@Autowired
	private AnnonceRepository annonceRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {

		List<Annonce> la = this.annonceRepo.findAll();

		// la.stream().forEach(a -> System.out.println(a.toString()));
		return ResponseEntity.ok(la); // this.annonceRepo.findAll();
	}

	// @RequestMapping(value = "{pseudo}", method = RequestMethod.PATCH,
	// consumes = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<?> updateScore(@RequestBody ActionVM actionVM,
	// @PathVariable("pseudo") String pseudo) {
	// Collegue collegue = collegueRepo.findByPseudo(pseudo);
	// if (collegue == null) {
	// return ResponseEntity.notFound().build();
	// }
	//
	// if (actionVM.getAction().equals(Avis.AIMER)) {
	// collegue.setScore(collegue.getScore() + 10);
	// } else if (actionVM.getAction().equals(Avis.DETESTER)) {
	// collegue.setScore(collegue.getScore() - 5);
	// }
	// collegueRepo.save(collegue);
	//
	// return ResponseEntity.ok(collegue);
	// }
}
