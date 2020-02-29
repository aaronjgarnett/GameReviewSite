/*
 * Filename: GameService.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.service;

import java.util.List;

import javax.persistence.Query;

import com.aaron.entities.Game;
import com.aaron.entities.Review;

/**
 * Sevice for Game Entity
 * 
 */
public class GameService extends MainService {
	/**
	 * @param g
	 */
	public static void addGame(Game g) {
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
	}

	/**
	 * @return q.setMaxResults(10).getResultList()
	 */
	@SuppressWarnings("unchecked")
	public static List<Game> getTopTenGames() {
		Query q = em.createNamedQuery("Game.findTopTen");
		return q.setMaxResults(10).getResultList();
	}

	/**
	 * @param id
	 * @return q.getSingleResult()
	 */
	public static Game getGameById(int id) {
		Query q = em.createNamedQuery("Game.findById");
		q.setParameter("givenID", id);
		return (Game) q.getSingleResult();
	}

	/**
	 * @param genreId
	 * @return q.setMaxResults(10).getResultList()
	 */
	@SuppressWarnings("unchecked")
	public static List<Game> getTopTenGamesByGenre(int genreId) {
		Query q = em.createNamedQuery("Game.findTopTenByGenre");
		q.setParameter("givenID", genreId);
		return q.setMaxResults(10).getResultList();
	}

	/**
	 * @return q.getResultList()
	 */
	@SuppressWarnings("unchecked")
	public static List<Game> getAllGames() {
		Query q = em.createNamedQuery("Game.findTopTen");
		return q.getResultList();
	}

	public static void updateScore(int id) {
		em.getTransaction().begin();
		Game g = em.find(Game.class, id);
		double average = 0;
		
		for (Review r : ReviewService.getAllReviewsByGame(g)) {
			average += r.getScore();
		}

		g.setAggregateScore(average / ReviewService.getAllReviewsByGame(g).size());
		em.getTransaction().commit();
	}
}
