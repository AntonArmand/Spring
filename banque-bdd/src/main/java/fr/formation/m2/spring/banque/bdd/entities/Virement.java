package fr.formation.m2.spring.banque.bdd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="virement")
public class Virement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="somme")
	private double somme;
	
	@ManyToOne(targetEntity=Compte.class)
	@JoinColumn(name="debiteur")
	private Compte compted;
	
	@ManyToOne(targetEntity=Compte.class)
	@JoinColumn(name="crediteur")
	private Compte comptec;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getSomme() {
		return somme;
	}

	public void setSomme(double somme) {
		this.somme = somme;
	}

	public Compte getCompted() {
		return compted;
	}

	public void setCompted(Compte compted) {
		this.compted = compted;
	}

	public Compte getComptec() {
		return comptec;
	}

	public void setComptec(Compte comptec) {
		this.comptec = comptec;
	}
}
