package com.arron.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return name;
	}

}