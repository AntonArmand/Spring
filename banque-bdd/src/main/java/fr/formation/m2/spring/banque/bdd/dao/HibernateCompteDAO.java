package fr.formation.m2.spring.banque.bdd.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import fr.formation.m2.spring.banque.bdd.entities.Client;
import fr.formation.m2.spring.banque.bdd.entities.Compte;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;

public class HibernateCompteDAO implements CompteDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void ajouterCompte(Compte compte) throws BanqueException {
		sessionFactory.getCurrentSession().save(compte);
	}

	@Override
	public Compte rechercherCompteParNumero(Long numero) throws BanqueException {
		try {
			return (Compte) sessionFactory.getCurrentSession().get(Compte.class, new Long(numero));
		} catch (HibernateException e) {
			throw new BanqueException("Erreur de recherche du compte");
		}
	}
	
	
	@Override
	public List<Compte> rechercherComptesClient(Client client) throws BanqueException {
		try {
			String hql = "from Compte as c where c.client=?";
			Session s = sessionFactory.getCurrentSession();
			Query q = s.createQuery(hql);
			q.setEntity(0, client);		
			return sessionFactory.getCurrentSession().createQuery(hql).setEntity(0, client).list();
		} catch (HibernateException e) {
			throw new BanqueException("Erreur de recherche des comptes");
		}
	}
	
	@Override
	  public void modifierCompte(Compte compte) throws BanqueException {
	    try {
	      sessionFactory.getCurrentSession().merge(compte);
	    }catch(HibernateException e){
	      throw new BanqueException("Erreur de modification de compte");
	    }

	  }

	@Override
	public List<Compte> listerCompte() throws BanqueException {
		String hql = "from Compte";
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery(hql);	
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	@Override
    public List<Compte> UsernameClient(Client client) throws BanqueException {
		String sql = "from Account as c where c.client=:client";
        return sessionFactory.getCurrentSession().createQuery(sql).setParameter("client", client).list();
    }
}
