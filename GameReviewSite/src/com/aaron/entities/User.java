/*
 * Filename: User.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :givenID") })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String avatar;

	private String email;

	@Column(name = "is_admin")
	private boolean isAdmin;

	@Column(name = "is_blocked")
	private boolean isBlocked;

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
		this.setAvatar("images/default_avatar.png");
		this.setEmail(email);
		this.setName(name);
		this.setPassword(password);
	}

	/**
	 * @param avatar
	 * @param email
	 * @param name
	 * @param password
	 */
	public User(String avatar, String email, String name, String password) {
		this.setAvatar(avatar);
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
	 * @return avatar
	 */
	public String getAvatar() {
		return this.avatar;
	}

	/**
	 * @param avater
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
	 * @return isAdmin
	 */
	public boolean getIsAdmin() {
		return this.isAdmin;
	}

	/**
	 * @param isAdmin
	 */
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return isBlocked
	 */
	public boolean getIsBlocked() {
		return this.isBlocked;
	}

	/**
	 * @param isBlocked
	 */
	public void setIsBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", avatar=");
		builder.append(avatar);
		builder.append(", email=");
		builder.append(email);
		builder.append(", isAdmin=");
		builder.append(isAdmin);
		builder.append(", isBlocked=");
		builder.append(isBlocked);
		builder.append(", name=");
		builder.append(name);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + (isBlocked ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (isBlocked != other.isBlocked)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
}