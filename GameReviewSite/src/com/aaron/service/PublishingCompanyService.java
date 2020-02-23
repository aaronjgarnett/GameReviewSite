/*
 * Filename: PublishingCompanyService.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.service;

import com.arron.entities.PublishingCompany;

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
}
