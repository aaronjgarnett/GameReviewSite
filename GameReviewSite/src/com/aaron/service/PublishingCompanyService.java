/**
 * 
 */
package com.aaron.service;

import com.arron.entities.PublishingCompany;

/**
 * @author aaron
 *
 *         Sevice for Publishing Company Entity
 */
public class PublishingCompanyService extends AbstractService {
	public static void addPublishingCompany(PublishingCompany p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
}
