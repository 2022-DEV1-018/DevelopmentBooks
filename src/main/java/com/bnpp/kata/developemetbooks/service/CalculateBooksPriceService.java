package com.bnpp.kata.developemetbooks.service;

import java.util.List;

import com.bnpp.kata.developemetbooks.model.BookApiRequest;

public class CalculateBooksPriceService {

	public double calculateBooksPrice(List<BookApiRequest> bookApiRequestList) {
		double calculatedPrice = 0d;
		double price = 50d;
		if (bookApiRequestList.size() == 1) {
			BookApiRequest bookApiRequest = bookApiRequestList.get(0);
			calculatedPrice = 50d * bookApiRequest.getQuantity();
		} else if (bookApiRequestList.size() == 2) {
			double basePrice = bookApiRequestList.size() * price;
			double discountedPriceForSet = basePrice - ((basePrice * 5) / 100.0);
			calculatedPrice += discountedPriceForSet;
		} else if (bookApiRequestList.size() == 3) {
			double basePrice = bookApiRequestList.size() * price;
			double discountedPriceForSet = basePrice - ((basePrice * 10) / 100.0);
			calculatedPrice += discountedPriceForSet;
		} else if (bookApiRequestList.size() == 4) {
			double basePrice = bookApiRequestList.size() * price;
			double discountedPriceForSet = basePrice - ((basePrice * 20) / 100.0);
			calculatedPrice += discountedPriceForSet;
		}
		return calculatedPrice;
	}
}
