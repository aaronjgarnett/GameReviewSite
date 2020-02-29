/*
 * Filename: ContactMessageTest.java
 * author: Aaron Garnett
 * date: 2/29/2020 original
 * 
 * */
package com.aaron.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aaron.service.ContactMessageService;
import com.aaron.service.MainService;

class ContactMessageTest {
	@BeforeEach
	void setUp() throws Exception {
		MainService.open();
	}

	@AfterEach
	void tearDown() throws Exception {
		MainService.close();
	}

	@Test
	void testGetAllMessages() {
		assertNotNull(ContactMessageService.getAllMessages());
	}
}
