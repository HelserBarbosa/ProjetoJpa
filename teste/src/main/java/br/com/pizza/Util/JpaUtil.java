package br.com.pizza.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizza");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}