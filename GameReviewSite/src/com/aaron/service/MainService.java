/*
 * Filename: MainService.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Abstract Service for JPA
 * 
 */
public abstract class MainService {
	protected static EntityManagerFactory emf;
	protected static EntityManager em;

	public static void open() {
		emf = Persistence.createEntityManagerFactory("GameReviewSite");
		em = emf.createEntityManager();
	}

	public static void close() {
		em.close();
		emf.close();
	}
}
