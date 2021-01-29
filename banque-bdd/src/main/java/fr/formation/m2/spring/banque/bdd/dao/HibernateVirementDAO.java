package fr.formation.m2.spring.banque.bdd.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import fr.formation.m2.spring.banque.bdd.entities.Client;
import fr.formation.m2.spring.banque.bdd.entities.Compte;
import fr.formation.m2.spring.banque.bdd.entities.Virement;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;

public class HibernateVirementDAO implements VirementDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void ajouterVirement(Virement virement) throws BanqueException {
		sessionFactory.getCurrentSession().persist(virement);
	}

	@Override
	public List<Virement> rechercherTousLesVirements() throws BanqueException {
		String hql = "from Virement as v";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	@Override
	public List<Virement> rechercherTousLesVirementsOneUser(Long id) throws BanqueException {
		String hql = "from Virement as v where v.debiteur=:id";
		return sessionFactory.getCurrentSession().createQuery(hql).setParameter("id", id).list();
	}
	
	@Override
	public Virement FindVirementByCpt(Compte cpt){
		String hql = "from Virement as v where v.compted =:cpt";
		return (Virement) sessionFactory.getCurrentSession().createQuery(hql).setParameter("cpt", cpt).uniqueResult();
		
	}

}
