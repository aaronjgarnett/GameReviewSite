/*
 * Filename: Game.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the game database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Game.findTopTen", query = "SELECT g FROM Game g ORDER BY g.aggregateScore DESC"),
		@NamedQuery(name = "Game.findById", query = "SELECT g FROM Game g WHERE g.id = :givenID"),
		@NamedQuery(name = "Game.findTopTenByGenre", query = "SELECT g FROM Game g INNER JOIN g.genres e WHERE e.id = :givenID ORDER BY g.aggregateScore DESC") })
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

	/**
	 * @param cover
	 * @param description
	 * @param name
	 * @param date
	 * @param genres
	 * @param publishingCompany
	 */
	public Game(String cover, String description, String name, Date date, List<Genre> genres,
			PublishingCompany publishingCompany) {
		this.setCover(cover);
		this.setDescription(description);
		this.setName(name);
		this.setDate(date);
		this.setGenres(genres);
		this.setPublishingCompany(publishingCompany);
	}

	public Game() {
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
	 * @return aggregateScore
	 */
	public double getAggregateScore() {
		return this.aggregateScore;
	}

	/**
	 * @param aggregateScore
	 */
	public void setAggregateScore(double aggregateScore) {
		this.aggregateScore = aggregateScore;
	}

	/**
	 * @return cover
	 */
	public String getCover() {
		return this.cover;
	}

	/**
	 * @param cover
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return date
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return genres
	 */
	public List<Genre> getGenres() {
		return this.genres;
	}

	/**
	 * @param genres
	 */
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	/**
	 * @return publishingCompany
	 */
	public PublishingCompany getPublishingCompany() {
		return this.publishingCompany;
	}

	/**
	 * @param publishingCompany
	 */
	public void setPublishingCompany(PublishingCompany publishingCompany) {
		this.publishingCompany = publishingCompany;
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
		review.setGame(this);

		return review;
	}

	/**
	 * @param review
	 * @return review
	 */
	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setGame(null);

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
		builder.append("Game [id=");
		builder.append(id);
		builder.append(", aggregateScore=");
		builder.append(aggregateScore);
		builder.append(", cover=");
		builder.append(cover);
		builder.append(", description=");
		builder.append(description);
		builder.append(", name=");
		builder.append(name);
		builder.append(", date=");
		builder.append(date);
		builder.append(", genres=");
		builder.append(genres);
		builder.append(", publishingCompany=");
		builder.append(publishingCompany);
		builder.append(", reviews=");
		builder.append(reviews);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(aggregateScore);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cover == null) ? 0 : cover.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((publishingCompany == null) ? 0 : publishingCompany.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
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
		Game other = (Game) obj;
		if (Double.doubleToLongBits(aggregateScore) != Double.doubleToLongBits(other.aggregateScore))
			return false;
		if (cover == null) {
			if (other.cover != null)
				return false;
		} else if (!cover.equals(other.cover))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (publishingCompany == null) {
			if (other.publishingCompany != null)
				return false;
		} else if (!publishingCompany.equals(other.publishingCompany))
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		return true;
	}
}