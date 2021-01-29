package fr.formation.m2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import fr.formation.m2.spring.banque.bdd.entities.Client;
import fr.formation.m2.spring.banque.bdd.entities.Compte;
import fr.formation.m2.spring.banque.metier.BanqueService;

@Controller
public class virementController {
	private static ApplicationContext contexte;
	
	@RequestMapping(value="/virement")
	public ModelAndView virement(HttpServletRequest req , HttpServletResponse rep) throws BanqueException {
		contexte = new ClassPathXmlApplicationContext(new String [] {"metier-context.xml" ,"bdd-context.xml"});
				
		Map<String , Object> model2 = new HashMap<String, Object>();				
		CompteDAO cpt = (CompteDAO) contexte.getBean("compteDAO");
		List<Compte> lesCompte = cpt.rechercherTousLesCompte();
		
		for(Compte compte : lesCompte ) {
			model2.put(Long.toString(compte.getNumero()), "Compte n°"+compte.getNumero()+" PROPRIETAIRE : "+compte.getClient().getNom()+" "+compte.getClient().getPrenom()+ "  SOLDE : "+ compte.getSolde());			
		}
		
		return new ModelAndView("virement","data",model2);
	}
	
	
	//apeller apres la validation du formulaire de virement
	@RequestMapping(value="/virement",method=RequestMethod.POST)
	public String virementaction(HttpServletRequest request, Model model) throws BanqueException {
		String debiter = request.getParameter("lists");
		String crediter = request.getParameter("lists2");
		String montant = request.getParameter("montant");
		
		
		contexte = new ClassPathXmlApplicationContext(new String [] {"metier-context.xml" ,"bdd-context.xml"});
		BanqueService banqueService = (BanqueService) contexte.getBean("BanqueService");
		banqueService.virement(Long.parseLong(debiter), Long.parseLong(crediter), Long.parseLong(montant));;
		
	
	
		return "redirect:/virement";
	}
	
	
	
	
	
}
