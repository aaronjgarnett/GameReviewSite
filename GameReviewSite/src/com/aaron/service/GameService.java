/**
 * 
 */
package com.aaron.service;

import java.util.List;

import javax.persistence.Query;

import com.arron.entities.Game;

/**
 * @author aaron
 *
 *         Sevice for Game Entity
 */
public class GameService extends AbstractService {
	public static void addGame(Game g) {
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public static List<Game> getTopTenGames() {
		Query q = em.createNamedQuery("Game.findTopTen");
		return q.setMaxResults(10).getResultList();
	}

	public static Game getGameById(int id) {
		Query q = em.createNamedQuery("Game.findById");
		q.setParameter("givenID", id);
		return (Game) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public static List<Game> getTopTenGamesByGenre(int genreId) {
		Query q = em.createNamedQuery("Game.findTopTenByGenre");
		q.setParameter("givenID", genreId);
		return q.setMaxResults(10).getResultList();
	}

	@SuppressWarnings("unchecked")
	public static List<Game> getAllGames() {
		Query q = em.createNamedQuery("Game.findTopTen");
		return q.getResultList();
	}
}