package dev.entite;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Annonce {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "HEURE", nullable = false)
	private LocalDateTime heure;

	@Column(name = "DUREE", nullable = false)
	private LocalTime duree;

	@Column(name = "DISTANCE", nullable = false)
	private Double distance;

	@Column(name = "PLACE_DISPONIBLE", nullable = false)
	private int placeDispo;

	@AttributeOverrides({ @AttributeOverride(name = "rue", column = @Column(name = "RUE_DEPART")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "CP_DEPART")),
			@AttributeOverride(name = "ville", column = @Column(name = "VILLE_DEPART")) })
	@Embedded
	private Adresse adresseDepart;

	@AttributeOverrides({ @AttributeOverride(name = "rue", column = @Column(name = "RUE_ARRIVER")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "CP_ARRIVER")),
			@AttributeOverride(name = "ville", column = @Column(name = "VILLE_ARRIVER")) })
	@Embedded
	private Adresse adresseArriver;

	@ManyToOne
	@JoinColumn(name = "CONDUCTEUR_ID", nullable = false)
	private Personne conducteur;

	@ManyToOne
	@JoinColumn(name = "VEHICULE_ID", nullable = false)
	private Vehicule vehicule;

	@ManyToMany
	@JoinTable(name = "ANNONCE_PASSAGER", joinColumns = @JoinColumn(name = "PASSAGER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ANNONCE_ID", referencedColumnName = "ID"))
	private List<Personne> passagers;

	/**
	 * 
	 */
	public Annonce() {
	}

	/**
	 * @param vehicule
	 * @param heure
	 * @param adresseDepart
	 * @param adresseArriver
	 * @param duree
	 * @param distance
	 * @param conducteur
	 * @param placeDispo
	 */
	public Annonce(Vehicule vehicule, LocalDateTime heure, Adresse adresseDepart, Adresse adresseArriver,
			LocalTime duree, Double distance, Personne conducteur, int placeDispo) {
		this.vehicule = vehicule;
		this.heure = heure;
		this.adresseDepart = adresseDepart;
		this.adresseArriver = adresseArriver;
		this.duree = duree;
		this.distance = distance;
		this.conducteur = conducteur;
		this.placeDispo = placeDispo;
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
	 * @return the heure
	 */
	public LocalDateTime getHeure() {
		return heure;
	}

	/**
	 * @param heure
	 *            the heure to set
	 */
	public void setHeure(LocalDateTime heure) {
		this.heure = heure;
	}

	/**
	 * @return the adresseDepart
	 */
	public Adresse getAdresseDepart() {
		return adresseDepart;
	}

	/**
	 * @param adresseDepart
	 *            the adresseDepart to set
	 */
	public void setAdresseDepart(Adresse adresseDepart) {
		this.adresseDepart = adresseDepart;
	}

	/**
	 * @return the adresseArriver
	 */
	public Adresse getAdresseArriver() {
		return adresseArriver;
	}

	/**
	 * @param adresseArriver
	 *            the adresseArriver to set
	 */
	public void setAdresseArriver(Adresse adresseArriver) {
		this.adresseArriver = adresseArriver;
	}

	/**
	 * @return the duree
	 */
	public LocalTime getDuree() {
		return duree;
	}

	/**
	 * @param duree
	 *            the duree to set
	 */
	public void setDuree(LocalTime duree) {
		this.duree = duree;
	}

	/**
	 * @return the distance
	 */
	public Double getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 *            the distance to set
	 */
	public void setDistance(Double distance) {
		this.distance = distance;
	}

	/**
	 * @return the conducteur
	 */
	public Personne getConducteur() {
		return conducteur;
	}

	/**
	 * @param conducteur
	 *            the conducteur to set
	 */
	public void setConducteur(Personne conducteur) {
		this.conducteur = conducteur;
	}

	/**
	 * @return the placeDispo
	 */
	public int getPlaceDispo() {
		return placeDispo;
	}

	/**
	 * @param placeDispo
	 *            the placeDispo to set
	 */
	public void setPlaceDispo(int placeDispo) {
		this.placeDispo = placeDispo;
	}

	/**
	 * @return the passagers
	 */
	public List<Personne> getPassagers() {
		return passagers;
	}

	/**
	 * @param passagers
	 *            the passagers to set
	 */
	public void setPassagers(List<Personne> passagers) {
		this.passagers = passagers;
	}

}
