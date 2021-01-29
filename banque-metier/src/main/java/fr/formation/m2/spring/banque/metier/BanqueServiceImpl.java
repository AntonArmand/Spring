package fr.formation.m2.spring.banque.metier;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.formation.m2.spring.banque.bdd.dao.ClientDAO;
import fr.formation.m2.spring.banque.bdd.dao.CompteDAO;
import fr.formation.m2.spring.banque.bdd.dao.HibernateClientDAO;
import fr.formation.m2.spring.banque.bdd.entities.Client;
import fr.formation.m2.spring.banque.bdd.entities.Compte;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;

public class BanqueServiceImpl implements BanqueService {
	
	private ClientDAO clientDAO;
	private CompteDAO compteDAO;
	private static ApplicationContext context;
	private static final Logger logger = LoggerFactory.getLogger(HibernateClientDAO.class);
	
	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	public void setCompteDAO(CompteDAO compteDAO) {
		this.compteDAO = compteDAO;
	}
	
	@Override
	public Client authentifier(String identifiant, String motDePasse) throws BanqueException {
		try {
			Client client = clientDAO.rechercherClientParId(Long.parseLong(identifiant));
			if (client != null && client.getMotdepasse().equals(motDePasse)) {
				return client;
			} else
				throw new BanqueException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BanqueException("Erreur d'authentification.");
		}
	}
	
	@Override
	public Client GetClientByUsername(String username) throws BanqueException {
        try {
            return clientDAO.searchClientByUsername(username);      
        } catch (Exception e) {
            e.printStackTrace();
            throw new BanqueException("An error occured with searching for user accounts");
        }
    }
	
	@Override
	public List<Compte> GetComptesByUsername(String username) throws BanqueException {
        try {
            Client client = clientDAO.searchClientByUsername(username);
            return compteDAO.UsernameClient(client);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BanqueException("An error occured with searching for user accounts");
        }
    }
	
	@Override
	public List<Compte> mesComptes(long idClient) throws BanqueException {
		try {
			Client client = clientDAO.rechercherClientParId(idClient);
			return compteDAO.rechercherComptesClient(client);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BanqueException("Erreur lors de la récupération de vos compte");
		}
	}
	
	@Override
	  public void virement(long numeroADebiter, long numeroACrediter, double montant) throws BanqueException {
		
		context = new ClassPathXmlApplicationContext("bdd-context.xml");
		CompteDAO compteDAO = (CompteDAO) context.getBean("compteDAO");
	    
	    Compte CompteDebiteur = compteDAO.rechercherCompteParNumero(numeroADebiter);
	    Compte CompteCrediteur = compteDAO.rechercherCompteParNumero(numeroACrediter);
	    
	    CompteDebiteur.setSolde(CompteDebiteur.getSolde() - montant);
	    CompteCrediteur.setSolde(CompteCrediteur.getSolde() + montant);
	    
	    compteDAO.modifierCompte(CompteDebiteur);
	    compteDAO.modifierCompte(CompteCrediteur);
	  }
}
