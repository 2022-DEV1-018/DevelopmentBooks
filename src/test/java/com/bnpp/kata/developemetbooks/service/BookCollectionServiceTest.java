package com.bnpp.kata.developemetbooks.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class BookCollectionServiceTest {
	private BookCollectionService bookCollectionService = new BookCollectionService();

	@Test
	public void getAllBooksShouldReturnFiveBooks() {
		Assertions.assertEquals(5, bookCollectionService.getAllBooks().size());
	}
}
