/*
 * Filename: UserService.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.service;

import java.util.List;

import javax.persistence.Query;

import com.arron.entities.User;

/**
 * Sevice for User Entity
 * 
 */
public class UserService extends MainService {
	/**
	 * @param u
	 */
	public static void addUser(User u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}

	/**
	 * @return q.getResultList()
	 */
	@SuppressWarnings("unchecked")
	public static List<User> getAllUsers() {
		Query q = em.createNamedQuery("User.findAll");
		return q.getResultList();
	}

	/**
	 * @param id
	 * @return q.getSingleResult()
	 */
	public static User getUserById(int id) {
		Query q = em.createNamedQuery("User.findById");
		q.setParameter("givenID", id);
		return (User) q.getSingleResult();
	}

	/**
	 * @param id
	 */
	public static void updateBlockStatus(int id) {
		em.getTransaction().begin();
		User u = em.find(User.class, id);
		if (u.getIsBlocked()) {
			u.setIsBlocked(false);
		} else {
			u.setIsBlocked(true);
		}
		em.getTransaction().commit();
	}
}
