package com.arron.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setUser(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setUser(null);

		return review;
	}

}