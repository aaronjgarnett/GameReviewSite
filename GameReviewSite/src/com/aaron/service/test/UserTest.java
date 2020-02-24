/*
 * Filename: UserTest.java
 * author: Aaron Garnett
 * date: 2/24/2020 original
 * 
 * */
package com.aaron.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aaron.service.MainService;
import com.aaron.service.UserService;

class UserTest {
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
	void test() {
		assertNotNull(UserService.getAllUsers());
	}

	@Test
	void testGetUserById() {
		assertNotNull(UserService.getUserById(1));
	}

	@Test
	void testGetUserByIdNoResult() {
		assertThrows(NoResultException.class, () -> {
			UserService.getUserById(255);
		});
	}
}
