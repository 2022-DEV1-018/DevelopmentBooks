package com.bnpp.kata.developemetbooks.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.bnpp.kata.developemetbooks.model.BookApiRequest;

public class CalculateBooksPriceServiceTest {
	
	private BookApiRequest bookApiRequest;
	
	private void setShoppingCart(int bookId, int quantity) {
		bookApiRequest = new BookApiRequest();
		bookApiRequest.setBookId(bookId);
		bookApiRequest.setQuantity(quantity);
	}

	@Test
	public void calculatePriceShouldReturnFiftyWhenUserBuysOneBook() {
		CalculateBooksPriceService calculateBooksPriceService = new CalculateBooksPriceService();
		setShoppingCart(1, 1);

		Assertions.assertEquals(50d, calculateBooksPriceService.calculateBooksPrice(bookApiRequest));
	}

	@Test
	public void calculatePriceShouldReturn100WhenUserBuysTwoBook() {
		CalculateBooksPriceService calculateBooksPriceService = new CalculateBooksPriceService();
		setShoppingCart(1, 2);

		Assertions.assertEquals(100d, calculateBooksPriceService.calculateBooksPrice(bookApiRequest));
	}
}
