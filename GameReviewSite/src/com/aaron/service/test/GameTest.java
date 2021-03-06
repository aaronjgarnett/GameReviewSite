/*
 * Filename: GameTest.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.service.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aaron.service.GameService;
import com.aaron.service.MainService;

class GameTest {
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MainService.open();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		MainService.close();
	}

	@Test
	void testGetTopTen() {
		assertNotNull(GameService.getTopTenGames());
	}

	@Test
	void testGetGameById() {
		assertNotNull(GameService.getGameById(1));
	}

	@Test
	void testGetGameByIdNoResult() {
		assertThrows(NoResultException.class, () -> {
			GameService.getGameById(255);
		});
	}

	@Test
	void testGetTopTenByGenre() {
		assertFalse(GameService.getTopTenGamesByGenre(1).isEmpty());
	}

	@Test
	void testGetTopTenByGenreNoResult() {
		assertTrue(GameService.getTopTenGamesByGenre(255).isEmpty());
	}

	@Test
	void testGetAllGames() {
		assertNotNull(GameService.getAllGames());
	}
}
