package com.bnpp.kata.developemetbooks.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CalculateBooksPriceServiceTest {
	@Test
	public void calculatePriceShouldReturnFiftyWhenUserBuysOneBook() {
		CalculateBooksPriceService calculateBooksPriceService = new CalculateBooksPriceService();

		Assertions.assertEquals(50d, calculateBooksPriceService.calculateBooksPrice("1"));
	}
}
