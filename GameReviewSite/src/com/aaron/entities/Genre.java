/*
 * Filename: Genre.java
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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the genre database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Genre.findById", query = "SELECT g FROM Genre g WHERE g.id = :givenID"),
		@NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g") })
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	// bi-directional many-to-many association to Game
	@ManyToMany(mappedBy = "genres")
	private List<Game> games;

	public Genre() {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Genre [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", games=");
		builder.append(games);
		builder.append("]");
		return builder.toString();
	}
}