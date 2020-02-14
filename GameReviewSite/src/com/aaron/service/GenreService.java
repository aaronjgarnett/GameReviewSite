/**
 * 
 */
package com.aaron.service;

import java.util.List;

import javax.persistence.Query;

import com.arron.entities.Genre;

/**
 * @author aaron
 *
 *         Sevice for Genre Entity
 */
public class GenreService extends AbstractService {
	public static void addGenre(Genre g) {
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public static List<Genre> getAllGenres() {
		Query q = em.createNamedQuery("Genre.findAll");
		return q.getResultList();
	}
}
