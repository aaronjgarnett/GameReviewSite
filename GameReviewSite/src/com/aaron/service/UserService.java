/**
 * 
 */
package com.aaron.service;

import java.util.List;

import javax.persistence.Query;

import com.arron.entities.User;

/**
 * @author aaron
 *
 *         Sevice for User Entity
 */
public class UserService extends AbstractService {
	public static void addUser(User u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public static List<User> getAllUsers() {
		Query q = em.createNamedQuery("User.findAll");
		return q.getResultList();
	}
}
