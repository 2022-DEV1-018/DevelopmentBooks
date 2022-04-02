package com.bnpp.kata.developemetbooks.service;

import java.util.ArrayList;
import java.util.List;

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
		List<BookApiRequest> bookApiRequestList = new ArrayList<>();
		setShoppingCart(1, 1);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(50d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));
	}

	@Test
	public void calculatePriceShouldReturn100WhenUserBuysTwoBook() {
		CalculateBooksPriceService calculateBooksPriceService = new CalculateBooksPriceService();
		List<BookApiRequest> bookApiRequestList = new ArrayList<>();
		setShoppingCart(1, 2);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(100d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));
	}

	@Test
	public void calculatePriceShouldApplyFivePercentDiscountWhenUserBuyTwoDifferentBooks() {
		CalculateBooksPriceService calculateBooksPriceService = new CalculateBooksPriceService();
		List<BookApiRequest> bookApiRequestItem = new ArrayList<>();
		setShoppingCart(1, 1);
		bookApiRequestItem.add(bookApiRequest);
		setShoppingCart(2, 1);
		bookApiRequestItem.add(bookApiRequest);

		Assertions.assertEquals(95d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestItem));
	}

	@Test
	public void calculatePriceShouldApplyTenPercentDiscountWhenUserBuyThreeDifferentBooks() {
		CalculateBooksPriceService calculateBooksPriceService = new CalculateBooksPriceService();
		List<BookApiRequest> bookApiRequestItem = new ArrayList<>();
		setShoppingCart(1, 1);
		bookApiRequestItem.add(bookApiRequest);
		setShoppingCart(2, 1);
		bookApiRequestItem.add(bookApiRequest);
		setShoppingCart(3, 1);
		bookApiRequestItem.add(bookApiRequest);

		Assertions.assertEquals(135d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestItem));
	}
}
