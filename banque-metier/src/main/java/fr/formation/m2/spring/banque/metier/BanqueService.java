package fr.formation.m2.spring.banque.metier;

import java.util.List;

import fr.formation.m2.spring.banque.bdd.entities.Client;
import fr.formation.m2.spring.banque.bdd.entities.Compte;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;

public interface BanqueService {
	
	public abstract Client authentifier(String identifiant, String motDePasse)
		throws BanqueException;
	
	public abstract List<Compte> mesComptes(long idClient) throws BanqueException;
	
	public abstract void virement (
			long numeroADebiter, long numeroACrediter, double montant)
				throws BanqueException;

	public abstract Client GetClientByUsername(String username) throws BanqueException;
	
	public abstract List<Compte> GetComptesByUsername(String username) throws BanqueException;
}
