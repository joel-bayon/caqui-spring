package fr.rte_france.caqui.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil { //Singleton ...
	static EntityManagerFactory factory ;
	
	private  JpaUtil(){}
	
	static {
		System.out.println("*** Démarrage de JPA .... ***");
		factory = Persistence.createEntityManagerFactory("caqui");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
	
}