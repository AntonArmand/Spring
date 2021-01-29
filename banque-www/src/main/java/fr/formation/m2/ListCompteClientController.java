package fr.formation.m2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.m2.spring.banque.bdd.dao.ClientDAO;
import fr.formation.m2.spring.banque.bdd.dao.CompteDAO;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;
import fr.formation.m2.spring.banque.bdd.entities.Client;
import fr.formation.m2.spring.banque.bdd.entities.Compte;

@Controller
public class ListCompteClientController {
	private static ApplicationContext contexte;
	
	
	@RequestMapping(value="/listCompte")
	public ModelAndView listeCompte(@RequestParam String param, Model model) throws BanqueException {
		contexte = new ClassPathXmlApplicationContext(new String [] {"metier-context.xml" ,"bdd-context.xml"});
		if (param.equals(null)) param ="erreur";
		
		
		Map<String , Object> model2 = new HashMap<String, Object>();	
		
		Long numbre = Long.parseLong(param) ;
		ClientDAO c = (ClientDAO) contexte.getBean("clientDAO");
	
		
		CompteDAO cpt = (CompteDAO) contexte.getBean("compteDAO");
		List<Compte> lesCompte = cpt.rechercherComptesClient(c.rechercherClientParId(numbre));
		
		
		for(Compte compte : lesCompte ) {
			model2.put(Long.toString(compte.getNumero()), compte.getSolde());			
		}
		
		return new ModelAndView("listCompte","data",model2);
	}
	
}
