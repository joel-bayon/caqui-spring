package fr.rte_france.caqui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.rte_france.caqui.entity.Etat;
import fr.rte_france.caqui.entity.Evenement;
import fr.rte_france.caqui.entity.Ouvrage;
import fr.rte_france.caqui.entity.OuvragePK;
import fr.rte_france.caqui.entity.Regroupement;
import fr.rte_france.caqui.service.CaquiException;
import fr.rte_france.caqui.service.GererRegroupement;



public class TestGererRegroupement {

	public static void main(String[] args) throws Exception  {
		
		ConfigurableApplicationContext spring = new ClassPathXmlApplicationContext("spring/spring.xml");
		GererRegroupement gererRegroupement = spring.getBean(GererRegroupement.class);
		
		try {
			Ouvrage o = new Ouvrage("mon ouvrage", new OuvragePK("idOuvrage", "ligne"));
			List<Evenement> evenements = new ArrayList<>();
			evenements.add(new Evenement("event1", new Date(), Etat.EN_ATTENTE, o));
			Regroupement regroupement = gererRegroupement.creerRegroupement("Schéma Exploitation", "un libelle", null, evenements);
			gererRegroupement.ajouterEvenement(regroupement.getId(), new Evenement("event2", new Date(), Etat.EN_COURS, o));
			
			System.out.println("regroupement =" + regroupement);
			gererRegroupement.ajouterEvenement(regroupement.getId(),new Evenement("event3", new Date(), Etat.CLOS, o));
		}
		catch (CaquiException e) {
			System.out.println("*** fin du test ***");
		}
		finally {
			spring.close();
		}
	}
}
