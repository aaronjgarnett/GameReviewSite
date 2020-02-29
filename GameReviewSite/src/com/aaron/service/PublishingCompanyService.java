/*
 * Filename: PublishingCompanyService.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.service;

import java.util.List;

import javax.persistence.Query;

import com.aaron.entities.PublishingCompany;

/**
 * Sevice for Publishing Company Entity
 * 
 */
public class PublishingCompanyService extends MainService {
	/**
	 * @param p
	 */
	public static void addPublishingCompany(PublishingCompany p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	/**
	 * @return q.getResultList()
	 */
	@SuppressWarnings("unchecked")
	public static List<PublishingCompany> getAllPublishers() {
		Query q = em.createNamedQuery("PublishingCompany.findAll");
		return q.getResultList();
	}
}
