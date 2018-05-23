package dev.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "MATRICULE")
	private String matricule;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;

	@Enumerated(EnumType.ORDINAL)
	private Role role;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "PHOTO")
	private String photo;

	@OneToMany(mappedBy = "conducteur")
	private List<Annonce> annoncePublier;

	@ManyToMany(mappedBy = "passagers")
	private List<Annonce> covoiturageReserver;

	@OneToMany(mappedBy = "chauffeur")
	private List<ReservationVehicule> reservationChauffeur;

	@OneToMany(mappedBy = "client")
	private List<ReservationVehicule> reservationClient;

	/**
	 * 
	 */
	public Personne() {
	}

	/**
	 * @param matricule
	 * @param nom
	 * @param prenom
	 * @param role
	 * @param email
	 * @param password
	 * @param photo
	 */
	public Personne(String matricule, String nom, String prenom, Role role, String email, String password,
			String photo) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.email = email;
		this.password = password;
		this.photo = photo;
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
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the annoncePublier
	 */
	public List<Annonce> getAnnoncePublier() {
		return annoncePublier;
	}

	/**
	 * @param annoncePublier
	 *            the annoncePublier to set
	 */
	public void setAnnoncePublier(List<Annonce> annoncePublier) {
		this.annoncePublier = annoncePublier;
	}

	/**
	 * @return the covoiturageReserver
	 */
	public List<Annonce> getCovoiturageReserver() {
		return covoiturageReserver;
	}

	/**
	 * @param covoiturageReserver
	 *            the covoiturageReserver to set
	 */
	public void setCovoiturageReserver(List<Annonce> covoiturageReserver) {
		this.covoiturageReserver = covoiturageReserver;
	}

	/**
	 * @return the reservationChauffeur
	 */
	public List<ReservationVehicule> getReservationChauffeur() {
		return reservationChauffeur;
	}

	/**
	 * @param reservationChauffeur
	 *            the reservationChauffeur to set
	 */
	public void setReservationChauffeur(List<ReservationVehicule> reservationChauffeur) {
		this.reservationChauffeur = reservationChauffeur;
	}

	/**
	 * @return the reservationClient
	 */
	public List<ReservationVehicule> getReservationClient() {
		return reservationClient;
	}

	/**
	 * @param reservationClient
	 *            the reservationClient to set
	 */
	public void setReservationClient(List<ReservationVehicule> reservationClient) {
		this.reservationClient = reservationClient;
	}
}