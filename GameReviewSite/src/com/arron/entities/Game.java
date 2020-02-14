package com.arron.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the game database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Game.findTopTen", query = "SELECT g FROM Game g ORDER BY g.aggregateScore"),
		@NamedQuery(name = "Game.findById", query = "SELECT g FROM Game g WHERE g.id = :givenID"),
		@NamedQuery(name = "Game.findTopTenByGenre", query = "SELECT g FROM Game g INNER JOIN g.genres e WHERE e.id = :givenID ORDER BY g.aggregateScore") })
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "aggregate_score")
	private double aggregateScore;

	// Source String for image file
	private String cover;

	@Lob
	private String description;

	private String name;

	@Temporal(TemporalType.DATE)
	private Date date;

	// bi-directional many-to-many association to Genre
	@ManyToMany
	@JoinTable(name = "game_genre", joinColumns = { @JoinColumn(name = "game_id") }, inverseJoinColumns = {
			@JoinColumn(name = "genre_id") })
	private List<Genre> genres;

	// bi-directional many-to-one association to PublishingCompany
	@ManyToOne
	@JoinColumn(name = "publisher")
	private PublishingCompany publishingCompany;

	// bi-directional many-to-one association to Review
	@OneToMany(mappedBy = "game")
	private List<Review> reviews;

	public Game() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAggregateScore() {
		return this.aggregateScore;
	}

	public void setAggregateScore(double aggregateScore) {
		this.aggregateScore = aggregateScore;
	}

	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Genre> getGenres() {
		return this.genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public PublishingCompany getPublishingCompany() {
		return this.publishingCompany;
	}

	public void setPublishingCompany(PublishingCompany publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setGame(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setGame(null);

		return review;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", aggregateScore=" + aggregateScore + ", cover=" + cover + ", description="
				+ description + ", name=" + name + ", date=" + date + ", publishingCompany=" + publishingCompany + "]";
	}

}