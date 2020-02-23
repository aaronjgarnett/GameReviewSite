/*
 * Filename: ReviewService.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.service;

import com.arron.entities.Review;

/**
 * Sevice for Review Entity
 * 
 */
public class ReviewService extends MainService {
	/**
	 * @param r
	 */
	public static void addReview(Review r) {
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
	}
}
