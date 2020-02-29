/*
 * Filename: ContactMessageService.java
 * author: Aaron Garnett
 * date: 2/29/2020 original
 * 
 * */
package com.aaron.service;

import java.util.List;

import javax.persistence.Query;

import com.aaron.entities.ContactMessage;

/**
 * Sevice for ContactMessage Entity
 *
 */
public class ContactMessageService extends MainService {
	/**
	 * @param c
	 */
	public static void addContactMessage(ContactMessage c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}

	/**
	 * @return q.getResultList()
	 */
	@SuppressWarnings("unchecked")
	public static List<ContactMessage> getAllMessages() {
		Query q = em.createNamedQuery("ContactMessage.findAll");
		return q.getResultList();
	}

	/**
	 * @param id
	 */
	public static void removeMessage(int id) {
		em.getTransaction().begin();
		ContactMessage c = em.find(ContactMessage.class, id);
		em.remove(c);
		em.getTransaction().commit();
	}
}
