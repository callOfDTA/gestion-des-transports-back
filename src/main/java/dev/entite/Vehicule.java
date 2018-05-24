package dev.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "IMMATRICULATION", nullable = false, unique = true)
	private String immatriculation;

	@Column(name = "MARQUE", nullable = false)
	private String marque;

	@Column(name = "MOMDELE", nullable = false)
	private String modele;

	@Column(name = "NOMBRE_PLACES", nullable = false)
	private int nbPlace;

	@Column(name = "URL_IMAGE", nullable = false)
	private String urlImage;

	@Enumerated(EnumType.ORDINAL)
	private StatusVehicule status;

	@Enumerated(EnumType.STRING)
	private CategorieVehicule categorie;

	@OneToMany(mappedBy = "vehicule")
	private List<Annonce> annonceCovoiturage;

	@OneToMany(mappedBy = "vehicule")
	private List<ReservationVehicule> reservationVoiture;

	/**
	 * 
	 */
	public Vehicule() {
	}

	/**
	 * @param immatriculation
	 * @param marque
	 * @param modele
	 * @param nbPlace
	 * @param urlImage
	 * @param status
	 * @param categorie
	 */
	public Vehicule(String immatriculation, String marque, String modele, int nbPlace, String urlImage,
			StatusVehicule status, CategorieVehicule categorie) {
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.nbPlace = nbPlace;
		this.urlImage = urlImage;
		this.status = status;
		this.categorie = categorie;
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
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * @param immatriculation
	 *            the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @param marque
	 *            the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * @param modele
	 *            the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 * @return the nbPlace
	 */
	public int getNbPlace() {
		return nbPlace;
	}

	/**
	 * @param nbPlace
	 *            the nbPlace to set
	 */
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	/**
	 * @return the urlImage
	 */
	public String getUrlImage() {
		return urlImage;
	}

	/**
	 * @param urlImage
	 *            the urlImage to set
	 */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	/**
	 * @return the status
	 */
	public StatusVehicule getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(StatusVehicule status) {
		this.status = status;
	}

	/**
	 * @return the categorie
	 */
	public CategorieVehicule getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(CategorieVehicule categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the annonceCovoiturage
	 */
	public List<Annonce> getAnnonceCovoiturage() {
		return annonceCovoiturage;
	}

	/**
	 * @param annonceCovoiturage
	 *            the annonceCovoiturage to set
	 */
	public void setAnnonceCovoiturage(List<Annonce> annonceCovoiturage) {
		this.annonceCovoiturage = annonceCovoiturage;
	}

	/**
	 * @return the reservationVoiture
	 */
	public List<ReservationVehicule> getReservationVoiture() {
		return reservationVoiture;
	}

	/**
	 * @param reservationVoiture
	 *            the reservationVoiture to set
	 */
	public void setReservationVoiture(List<ReservationVehicule> reservationVoiture) {
		this.reservationVoiture = reservationVoiture;
	}

}
