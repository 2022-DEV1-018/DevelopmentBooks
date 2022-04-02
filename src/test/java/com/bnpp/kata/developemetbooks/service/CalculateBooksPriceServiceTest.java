package com.bnpp.kata.developemetbooks.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.bnpp.kata.developemetbooks.model.BookApiRequest;

public class CalculateBooksPriceServiceTest {

	private BookApiRequest bookApiRequest;
	private CalculateBooksPriceService calculateBooksPriceService;
	private List<BookApiRequest> bookApiRequestList;

	private void setShoppingCart(int bookId, int quantity) {
		bookApiRequest = new BookApiRequest();
		bookApiRequest.setBookId(bookId);
		bookApiRequest.setQuantity(quantity);
	}

	@Before
	public void init() {
		calculateBooksPriceService = new CalculateBooksPriceService();
		bookApiRequestList = new ArrayList<>();
	}

	@Test
	public void calculatePriceShouldReturnFiftyWhenUserBuysOneBook() {
		setShoppingCart(1, 1);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(50d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));
	}

	@Test
	public void calculatePriceShouldReturnHundredWhenUserBuysTwoBook() {
		setShoppingCart(1, 2);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(100d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));
	}

	@Test
	public void calculatePriceShouldApplyFivePercentDiscountWhenUserBuyTwoDifferentBooks() {
		setShoppingCart(1, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(2, 1);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(95d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));
	}

	@Test
	public void calculatePriceShouldApplyTenPercentDiscountWhenUserBuyThreeDifferentBooks() {
		setShoppingCart(1, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(2, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(3, 1);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(135d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));
	}

	@Test
	public void calculatePriceShouldApplyTwentyPercentDiscountWhenUserBuyFourDifferentBooks() {
		setShoppingCart(1, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(2, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(3, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(4, 1);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(160d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));
	}

	@Test
	public void calculatePriceShouldApplyTwentyFivePercentDiscountWhenUserBuyFiveDifferentBooks() {
		setShoppingCart(1, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(2, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(3, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(4, 1);
		bookApiRequestList.add(bookApiRequest);
		setShoppingCart(5, 1);
		bookApiRequestList.add(bookApiRequest);

		Assertions.assertEquals(187.5d, calculateBooksPriceService.calculateBooksPrice(bookApiRequestList));
	}
}
