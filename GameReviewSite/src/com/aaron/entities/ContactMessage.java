/*
 * Filename: ContactMessage.java
 * author: Aaron Garnett
 * date: 2/24/2020 original
 * 
 * */
package com.aaron.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the contact_message database table.
 * 
 */
@Entity
@Table(name = "contact_message")
@NamedQuery(name = "ContactMessage.findAll", query = "SELECT c FROM ContactMessage c")
public class ContactMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String author;

	private String email;

	@Lob
	private String message;

	/**
	 * @param author
	 * @param email
	 * @param message
	 */
	public ContactMessage(String author, String email, String message) {
		this.author = author;
		this.email = email;
		this.message = message;
	}

	public ContactMessage() {
	}

	/**
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return author
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}