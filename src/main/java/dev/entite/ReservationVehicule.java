package dev.entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ReservationVehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "DATE_DEBUT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime dateDebut;

	@Column(name = "DATE_FIN")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime dateFin;

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

	/**
	 * 
	 */
	public ReservationVehicule() {
	}

	/**
	 * @param deteDebut
	 * @param deteFin
	 * @param avecChauffeur
	 * @param vehicule
	 * @param chauffeur
	 * @param client
	 */
	public ReservationVehicule(LocalDateTime deteDebut, LocalDateTime deteFin, boolean avecChauffeur, Vehicule vehicule,
			Personne chauffeur, Personne client) {
		this.dateDebut = deteDebut;
		this.dateFin = deteFin;
		this.avecChauffeur = avecChauffeur;
		this.vehicule = vehicule;
		this.chauffeur = chauffeur;
		this.client = client;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the deteDebut
	 */
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param deteDebut
	 *            the deteDebut to set
	 */
	public void setDateDebut(LocalDateTime deteDebut) {
		this.dateDebut = deteDebut;
	}

	/**
	 * @return the deteFin
	 */
	public LocalDateTime getDateFin() {
		return dateFin;
	}

	/**
	 * @param deteFin
	 *            the deteFin to set
	 */
	public void setDateFin(LocalDateTime deteFin) {
		this.dateFin = deteFin;
	}

	/**
	 * @return the avecChauffeur
	 */
	public boolean isAvecChauffeur() {
		return avecChauffeur;
	}

	/**
	 * @param avecChauffeur
	 *            the avecChauffeur to set
	 */
	public void setAvecChauffeur(boolean avecChauffeur) {
		this.avecChauffeur = avecChauffeur;
	}

	/**
	 * @return the vehicule
	 */
	public Vehicule getVehicule() {
		return vehicule;
	}

	/**
	 * @param vehicule
	 *            the vehicule to set
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	/**
	 * @return the chauffeur
	 */
	public Personne getChauffeur() {
		return chauffeur;
	}

	/**
	 * @param chauffeur
	 *            the chauffeur to set
	 */
	public void setChauffeur(Personne chauffeur) {
		this.chauffeur = chauffeur;
	}

	/**
	 * @return the client
	 */
	public Personne getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Personne client) {
		this.client = client;
	}

}
