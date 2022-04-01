package com.bnpp.kata.developemetbooks.service;

import com.bnpp.kata.developemetbooks.model.BookApiRequest;

public class CalculateBooksPriceService {

	public double calculateBooksPrice(BookApiRequest bookApiRequest) {
		return 50D * bookApiRequest.getQuantity();
	}

}
