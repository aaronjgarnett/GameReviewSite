/*
 * Filename: ReviewTest.java
 * author: Aaron Garnett
 * date: 2/24/2020 original
 * 
 * */
package com.aaron.service.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aaron.service.GameService;
import com.aaron.service.MainService;
import com.aaron.service.ReviewService;

class ReviewTest {
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
	void testGetAllReviews() {
		assertNotNull(ReviewService.getAllReviews());
	}

	@Test
	void testGetAllReviewsByGame() {
		assertFalse(ReviewService.getAllReviewsByGame(GameService.getGameById(1)).isEmpty());
	}

	@Test
	void testGetAllReviewsByGameNoResult() {
		assertThrows(NoResultException.class, () -> {
			ReviewService.getAllReviewsByGame(GameService.getGameById(255));
		});
	}
}
