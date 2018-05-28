package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {

}
