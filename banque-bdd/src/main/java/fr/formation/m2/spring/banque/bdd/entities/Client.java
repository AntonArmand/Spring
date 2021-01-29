package fr.formation.m2.spring.banque.bdd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Query;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="codepostal")
	private String codepostal;
	
	@Column(name="ville")
	private String ville;
	
	@Column(name="password")
	private String password;
	
	@Column(name="username")
	private String username;
	
	@Column(name="enabled")
	private int enabled;
	
	@Column(name="authority")
	private String authority;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
	
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getMotdepasse() {
		return password;
	}

	public void setMotdepasse(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}
	
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
