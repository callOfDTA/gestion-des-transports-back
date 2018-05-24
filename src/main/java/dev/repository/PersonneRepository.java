package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {

}
