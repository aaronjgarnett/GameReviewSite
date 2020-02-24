/*
 * Filename: PublishingCompanyTest.java
 * author: Aaron Garnett
 * date: 2/24/2020 original
 * 
 * */
package com.aaron.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aaron.service.MainService;
import com.aaron.service.PublishingCompanyService;

class PublishingCompanyTest {
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
	void testGetAllPublishers() {
		assertNotNull(PublishingCompanyService.getAllPublishers());
	}
}
