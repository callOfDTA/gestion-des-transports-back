package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {

}
