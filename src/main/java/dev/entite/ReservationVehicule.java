package dev.entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReservationVehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "DATE_DEBUT")
	private LocalDateTime deteDebut;

	@Column(name = "DATE_FIN")
	private LocalDateTime deteFin;

	@Column(name = "AVEC_CHAUFFEUR")
	private boolean avecChauffeur;

	@ManyToOne
	@JoinColumn(name = "VEHICULE_ID", nullable = false)
	private Vehicule vehicule;

	@ManyToOne
	@JoinColumn(name = "CHAUFFEUR_ID", nullable = false)
	private Personne chauffeur;

	@ManyToOne
	@JoinColumn(name = "PASSAGER_ID", nullable = false)
	private Personne client;

}
