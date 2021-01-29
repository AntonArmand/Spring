package fr.formation.m2.spring.banque.bdd.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.formation.m2.spring.banque.bdd.entities.Client;
import fr.formation.m2.spring.banque.bdd.entities.Compte;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;

public class HibernateClientDAO implements ClientDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void ajouterClient(Client client) throws BanqueException {
		sessionFactory.getCurrentSession().persist(client);
	}
	
	@Override
	public void modifierClient(Client client) throws BanqueException {
		sessionFactory.getCurrentSession().update(client);
	}
	
	@Override
	public void supprimerClient(Client client) throws BanqueException {
		sessionFactory.getCurrentSession().delete(client);
	}

	@Override
	public Client rechercherClientParId(Long id) throws BanqueException {
		return (Client) sessionFactory.getCurrentSession().get(Client.class, new Long(id));
	}

	@Override
	public List<Client> rechercherTousLesClients() throws BanqueException {
		String hql = "from Client as c";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	public Client searchClientByUsername(String username) throws BanqueException {
		/*String query = "from Client as c where c.username = :username";
        return (Client) sessionFactory.getCurrentSession().createQuery(query).setParameter("username", username).getSingleResult();*/
		try {
			String hql = "from Client c where c.username = :username";
	        return (Client) sessionFactory.getCurrentSession().createQuery(hql).setParameter("username", username).uniqueResult();
	    } catch (HibernateException exception) {
	        throw new BanqueException("Cannot load client with username: " + username + " from database.");
	    }
    }
}
