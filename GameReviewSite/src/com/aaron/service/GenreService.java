/*
 * Filename: GenreService.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.service;

import java.util.List;

import javax.persistence.Query;

import com.aaron.entities.Genre;

/**
 * Sevice for Genre Entity
 * 
 */
public class GenreService extends MainService {
	/**
	 * @param g
	 */
	public static void addGenre(Genre g) {
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
	}

	/**
	 * @return q.getResultList()
	 */
	@SuppressWarnings("unchecked")
	public static List<Genre> getAllGenres() {
		Query q = em.createNamedQuery("Genre.findAll");
		return q.getResultList();
	}
}
