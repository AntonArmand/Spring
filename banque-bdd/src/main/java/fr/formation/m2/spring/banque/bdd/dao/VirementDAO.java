package fr.formation.m2.spring.banque.bdd.dao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.m2.spring.banque.bdd.entities.Client;
import fr.formation.m2.spring.banque.bdd.entities.Compte;
import fr.formation.m2.spring.banque.bdd.entities.Virement;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;

public interface VirementDAO {

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BanqueException.class)
	public abstract void ajouterVirement(Virement virement) throws BanqueException;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public abstract List<Virement> rechercherTousLesVirements() throws BanqueException;

	@Transactional(propagation=Propagation.REQUIRED)
	public abstract List<Virement> rechercherTousLesVirementsOneUser(Long id) throws BanqueException;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public abstract Virement FindVirementByCpt(Compte cpt) throws BanqueException;
	
}
