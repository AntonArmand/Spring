package fr.formation.m2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.m2.spring.banque.bdd.dao.ClientDAO;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;
import fr.formation.m2.spring.banque.bdd.entities.Client;

@Controller
public class FormController {
	private static ApplicationContext contexte;
	// affichage du formulaire vide
	
	@RequestMapping(value="/ajoutClient")
	public String ajoutClient() {
		return "addClient";//2 le formulaire a appeler
	}
	
	//apeller apres la validation du formulaire d'ajout de client
	@RequestMapping(value="/ajoutClient",method=RequestMethod.POST)
	public String ClientAjoute(HttpServletRequest request, Model model) throws BanqueException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String codepostal = request.getParameter("codepostal");
		String ville = request.getParameter("ville");
		String mdp = request.getParameter("mdp");
		Client c = new Client();
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setAdresse(adresse);
		c.setVille(ville);
		c.setCodepostal(codepostal);
		c.setMotdepasse(mdp);
		contexte = new ClassPathXmlApplicationContext(new String [] {"metier-context.xml" ,"bdd-context.xml"});
		ClientDAO cDAO = (ClientDAO) contexte.getBean("clientDAO");
		
		cDAO.ajouterClient(c);
		
		System.out.println("client = "+c);
		model.addAttribute("client", c);
		
		return "redirect:/ajoutClient";
	}
	
	
	
	
}
