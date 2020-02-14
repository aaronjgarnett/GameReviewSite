package com.arron.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the publishing_company database table.
 * 
 */
@Entity
@Table(name="publishing_company")
@NamedQuery(name="PublishingCompany.findAll", query="SELECT p FROM PublishingCompany p")
public class PublishingCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="publishingCompany")
	private List<Game> games;

	public PublishingCompany() {
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

	public Game addGame(Game game) {
		getGames().add(game);
		game.setPublishingCompany(this);

		return game;
	}

	public Game removeGame(Game game) {
		getGames().remove(game);
		game.setPublishingCompany(null);

		return game;
	}

}