/*
 * Filename: User.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.arron.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private String name;

	private String password;

	// bi-directional many-to-one association to Review
	@OneToMany(mappedBy = "user")
	private List<Review> reviews;

	/**
	 * @param email
	 * @param name
	 * @param password
	 */
	public User(String email, String name, String password) {
		this.setEmail(email);
		this.setName(name);
		this.setPassword(password);
	}

	public User() {
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
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return reviews
	 */
	public List<Review> getReviews() {
		return this.reviews;
	}

	/**
	 * @param reviews
	 */
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	/**
	 * @param review
	 * @return review
	 */
	public Review addReview(Review review) {
		getReviews().add(review);
		review.setUser(this);

		return review;
	}

	/**
	 * @param review
	 * @return review
	 */
	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setUser(null);

		return review;
	}
}