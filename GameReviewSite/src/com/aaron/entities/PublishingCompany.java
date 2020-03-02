/*
 * Filename: PublishingCompany.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the publishing_company database table.
 * 
 */
@Entity
@Table(name = "publishing_company")
@NamedQuery(name = "PublishingCompany.findAll", query = "SELECT p FROM PublishingCompany p")
public class PublishingCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	// bi-directional many-to-one association to Game
	@OneToMany(mappedBy = "publishingCompany")
	private List<Game> games;

	/**
	 * @param name
	 * @param games
	 */
	public PublishingCompany(String name, List<Game> games) {
		this.name = name;
		this.games = games;
	}

	public PublishingCompany() {
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
	 * @return games
	 */
	public List<Game> getGames() {
		return this.games;
	}

	/**
	 * @param games
	 */
	public void setGames(List<Game> games) {
		this.games = games;
	}

	/**
	 * @param game
	 * @return game
	 */
	public Game addGame(Game game) {
		getGames().add(game);
		game.setPublishingCompany(this);

		return game;
	}

	/**
	 * @param game
	 * @return game
	 */
	public Game removeGame(Game game) {
		getGames().remove(game);
		game.setPublishingCompany(null);

		return game;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PublishingCompany [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", games=");
		builder.append(games);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((games == null) ? 0 : games.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		PublishingCompany other = (PublishingCompany) obj;
		if (games == null) {
			if (other.games != null)
				return false;
		} else if (!games.equals(other.games))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}