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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactMessage [id=");
		builder.append(id);
		builder.append(", author=");
		builder.append(author);
		builder.append(", email=");
		builder.append(email);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactMessage other = (ContactMessage) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}
}