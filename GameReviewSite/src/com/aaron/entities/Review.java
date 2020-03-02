/*
 * Filename: Review.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the reviews database table.
 * 
 */
@Entity
@Table(name = "review")
@NamedQueries({ @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r"),
		@NamedQuery(name = "Review.findAllByGame", query = "SELECT r FROM Review r WHERE r.game = :givenGame") })
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Lob
	private String content;

	private double score;

	// bi-directional many-to-one association to Game
	@ManyToOne
	@JoinColumn(name = "game")
	private Game game;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "author")
	private User user;

	/**
	 * @param content
	 * @param score
	 * @param game
	 * @param user
	 */
	public Review(String content, double score, Game game, User user) {
		this.setContent(content);
		this.setScore(score);
		this.setGame(game);
		this.setUser(user);
	}

	public Review() {
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
	 * @return content
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return score
	 */
	public double getScore() {
		return this.score;
	}

	/**
	 * @param score
	 */
	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * @return game
	 */
	public Game getGame() {
		return this.game;
	}

	/**
	 * @param game
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return user
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [id=");
		builder.append(id);
		builder.append(", content=");
		builder.append(content);
		builder.append(", score=");
		builder.append(score);
		builder.append(", game=");
		builder.append(game);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((game == null) ? 0 : game.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Review other = (Review) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (game == null) {
			if (other.game != null)
				return false;
		} else if (!game.equals(other.game))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}