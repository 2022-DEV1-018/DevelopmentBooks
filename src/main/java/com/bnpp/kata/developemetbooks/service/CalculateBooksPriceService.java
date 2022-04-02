package com.bnpp.kata.developemetbooks.service;

import java.util.ArrayList;
import java.util.List;

import com.bnpp.kata.developemetbooks.model.BookApiRequest;

public class CalculateBooksPriceService {

	private static final double TOTAL_PERCENTAGE = 100.0;
	private static final int FIRST_INDEX = 0;

	public double calculateBooksPrice(List<BookApiRequest> bookApiRequestList) {
		double calculatedPrice = 0d;
		double price = 50d;
		if (bookApiRequestList.size() == 1) {
			BookApiRequest bookApiRequest = bookApiRequestList.get(FIRST_INDEX);
			calculatedPrice = 50d * bookApiRequest.getQuantity();
		} else if (bookApiRequestList.size() == 2) {
			double basePrice = bookApiRequestList.size() * price;
			double discountedPriceForSet = basePrice - ((basePrice * 5) / TOTAL_PERCENTAGE);
			calculatedPrice += discountedPriceForSet;
		} else if (bookApiRequestList.size() == 3) {
			double basePrice = bookApiRequestList.size() * price;
			double discountedPriceForSet = basePrice - ((basePrice * 10) / TOTAL_PERCENTAGE);
			calculatedPrice += discountedPriceForSet;
		} else if (bookApiRequestList.size() == 4) {
			double basePrice = bookApiRequestList.size() * price;
			double discountedPriceForSet = basePrice - ((basePrice * 20) / TOTAL_PERCENTAGE);
			calculatedPrice += discountedPriceForSet;
		} else if (bookApiRequestList.size() == 5) {
			double basePrice = bookApiRequestList.size() * price;
			double discountedPriceForSet = basePrice - ((basePrice * 25) / TOTAL_PERCENTAGE);
			calculatedPrice += discountedPriceForSet;
		}
		return calculatedPrice;
	}

	protected List<Integer> getBookIdList(List<BookApiRequest> bookRequestList) {
		List<Integer> bookIdList = new ArrayList<>();
		for (BookApiRequest bookApiRequest : bookRequestList) {
			addBookId(bookIdList, bookApiRequest);
		}
		return bookIdList;
	}

	protected List<Integer> addBookId(List<Integer> bookIdList, BookApiRequest bookApiRequest) {
		for (int i = 0; i < bookApiRequest.getQuantity(); i++) {
			bookIdList.add(bookApiRequest.getBookId());
		}
		return bookIdList;
	}
}
