package com.bnpp.kata.developemetbooks;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.bnpp.kata.developemetbooks.service.BookCollectionService;

public class BookCollectionServiceTest {
	private BookCollectionService bookCollectionService = new BookCollectionService();

	@Test
	public void getAllBooksShouldReturnFiveBooks() {
		Assertions.assertEquals(5, bookCollectionService.getAllBooks().size());
	}
}
