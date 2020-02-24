/*
 * Filename: ReviewService.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.service;

import java.util.List;

import javax.persistence.Query;

import com.arron.entities.Game;
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
		GameService.updateScore(r.getGame().getId());
	}

	/**
	 * @return q.getResultList()
	 */
	@SuppressWarnings("unchecked")
	public static List<Review> getAllReviews() {
		Query q = em.createNamedQuery("Review.findAll");
		return q.getResultList();
	}

	/**
	 * @return q.getResultList()
	 */
	@SuppressWarnings("unchecked")
	public static List<Review> getAllReviewsByGame(Game g) {
		Query q = em.createNamedQuery("Review.findAllByGame");
		q.setParameter("givenGame", g);
		return q.getResultList();
	}

	public static void removeReview(int id) {
		em.getTransaction().begin();
		Review r = em.find(Review.class, id);
		em.remove(r);
		em.getTransaction().commit();
		GameService.updateScore(r.getGame().getId());
	}
}
