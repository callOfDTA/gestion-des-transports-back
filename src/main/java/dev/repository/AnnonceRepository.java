package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Annonce;
import dev.entite.Personne;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {

	List<Personne> passagers(Annonce a);

}
