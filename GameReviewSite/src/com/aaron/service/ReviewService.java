/**
 * 
 */
package com.aaron.service;

import com.arron.entities.Review;

/**
 * @author aaron
 *
 *         Sevice for Review Entity
 */
public class ReviewService extends AbstractService {
	public static void addReview(Review r) {
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
	}
}
