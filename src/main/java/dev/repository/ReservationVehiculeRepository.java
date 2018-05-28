package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.ReservationVehicule;

public interface ReservationVehiculeRepository extends JpaRepository<ReservationVehicule, Integer> {

}
