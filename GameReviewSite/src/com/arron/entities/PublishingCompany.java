/*
 * Filename: PublishingCompany.java
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
}