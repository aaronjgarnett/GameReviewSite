package com.aaron.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.aaron.service.GameService;

class GameTest {
	@Test
	void testGetTopTen() {
		assertNotNull(GameService.getTopTenGames());
	}
	
	@Test
	void testGetTopTenByGenre() {
		assertNotNull(GameService.getTopTenGamesByGenre(1));
	}
}
