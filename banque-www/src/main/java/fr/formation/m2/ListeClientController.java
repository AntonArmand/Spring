package fr.formation.m2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.m2.spring.banque.bdd.dao.ClientDAO;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;
import fr.formation.m2.spring.banque.bdd.entities.Client;

@Controller
public class ListeClientController {
	private static ApplicationContext contexte;
	
	@RequestMapping(value="/listClient")
	public ModelAndView listClient(HttpServletRequest req , HttpServletResponse rep) throws BanqueException {
		contexte = new ClassPathXmlApplicationContext(new String [] {"metier-context.xml" ,"bdd-context.xml"});
		
		Map<String , Object> model = new HashMap<String, Object>();
		
		
		ClientDAO c = (ClientDAO) contexte.getBean("clientDAO");		
		List<Client> LesClient = null;
		LesClient = c.rechercherTousLesClient();
		
		for(Client client : LesClient ) {
			model.put(client.getNom()+" "+client.getPrenom(), client.getId());				
		}
		
	
		return new ModelAndView("listClient","data",model);
	}
	
	
}
