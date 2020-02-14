/**
 * 
 */
package com.aaron.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author aaron
 * 
 *         Abstract Service for JPA
 */
public abstract class AbstractService {
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GameReviewSite");
	protected static EntityManager em = emf.createEntityManager();
	
	public static void close() {
		em.close();
		emf.close();
	}
}
