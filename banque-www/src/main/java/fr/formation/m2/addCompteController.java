package fr.formation.m2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.m2.spring.banque.bdd.dao.ClientDAO;
import fr.formation.m2.spring.banque.bdd.dao.CompteDAO;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;
import fr.formation.m2.spring.banque.bdd.entities.Compte;
@Controller
public class addCompteController {
private static ApplicationContext contexte;
	

	@RequestMapping(value="/addCompte")
	public String listeCompte(@RequestParam String param) {
		return "addCompte";//2 le formulaire a appeler
	}

	
	@RequestMapping(value="/addCompte",method=RequestMethod.POST)
	public String listeCompte(@RequestParam String param,HttpServletRequest request, Model model) throws BanqueException {
		contexte = new ClassPathXmlApplicationContext(new String [] {"metier-context.xml" ,"bdd-context.xml"});
		if (param.equals(null)) param ="erreur";
		String montant = request.getParameter("montant");
		
		Map<String , Object> model2 = new HashMap<String, Object>();	
		
		Long idClient = Long.parseLong(param) ;
		ClientDAO c = (ClientDAO) contexte.getBean("clientDAO");		
		CompteDAO cpt = (CompteDAO) contexte.getBean("compteDAO");		
		Compte cpt1= new Compte();
		cpt1.setClient(c.rechercherClientParId(idClient));
		cpt1.setSolde(Double.parseDouble(montant));
		cpt.ajouterCompte(cpt1);
		
		
		
		return "redirect:/addCompte?param="+param  ;
	}
}
