package fr.rte_france.caqui;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.rte_france.caqui.dao.EvenementDao;
import fr.rte_france.caqui.entity.Etat;
import fr.rte_france.caqui.entity.Evenement;
import fr.rte_france.caqui.entity.Ouvrage;
import fr.rte_france.caqui.entity.OuvragePK;
import fr.rte_france.caqui.service.CaquiException;



public class TestEvenementDao {

	public static void main(String[] args) throws CaquiException {
		
		ConfigurableApplicationContext spring = new ClassPathXmlApplicationContext("spring/spring.xml");
		EvenementDao evenementDao    = spring.getBean(EvenementDao.class);
		
		
		Ouvrage o = new Ouvrage("mon ouvrage", new OuvragePK("idOuvrage", "ligne"));
	    Evenement evenement =  new Evenement("event2", new Date(), Etat.EN_COURS, o);
	    evenementDao.save(evenement);
	    spring.close();
		
		
	}
}
