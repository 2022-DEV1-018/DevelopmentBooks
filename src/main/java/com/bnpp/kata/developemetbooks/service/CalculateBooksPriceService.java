package com.bnpp.kata.developemetbooks.service;

import java.util.ArrayList;
import java.util.List;

import com.bnpp.kata.developemetbooks.model.BookApiRequest;
import com.bnpp.kata.developemetbooks.model.DiscountEnum;

public class CalculateBooksPriceService {

	private static final int BOOK_PRICE = 50;
	private static final double TOTAL_PERCENTAGE = 100.0;

	public double calculateBooksPrice(List<BookApiRequest> bookApiRequestList) {
		List<Integer> inputBookIds = getBookIdList(bookApiRequestList);
		List<List<Integer>> defaultCombinationSets = getDefaultBooksCombination(inputBookIds);
		return getBooksPrice(defaultCombinationSets);
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

	protected List<List<Integer>> getDefaultBooksCombination(List<Integer> bookList) {
		List<List<Integer>> bookListSets = new ArrayList<>();
		List<Integer> initList = new ArrayList<>();
		bookListSets.add(initList);

		for (Integer bookId : bookList) {
			boolean bookAddedToExistingSet = addBookToExistingSet(bookListSets, bookId);
			if (!bookAddedToExistingSet) {
				addBookToNewSet(bookListSets, bookId);
			}
		}
		return bookListSets;
	}

	private void addBookToNewSet(List<List<Integer>> bookListSets, Integer bookId) {
		List<Integer> newSet = new ArrayList<>();
		newSet.add(bookId);
		bookListSets.add(newSet);
	}

	private boolean addBookToExistingSet(List<List<Integer>> bookListSets, Integer bookId) {
		boolean bookAddedToExistingSet = false;
		for (List<Integer> list : bookListSets) {
			if (!list.contains(bookId)) {
				list.add(bookId);
				bookAddedToExistingSet = true;
				break;
			}
		}
		return bookAddedToExistingSet;
	}

	protected double getBooksPrice(List<List<Integer>> bookListSets) {
		double totalPrice = 0d;
		for (List<Integer> bookIds : bookListSets) {
			Double discountForSet = DiscountEnum.getDiscounts().get(bookIds.size());
			totalPrice += calculateDiscountedPrice(bookIds, discountForSet);
		}
		return totalPrice;
	}

	private double calculateDiscountedPrice(List<Integer> set, double discountForSet) {
		double calculatedPrice = 0d;
		double basePrice = set.size() * BOOK_PRICE;
		double discountedPriceForSet = basePrice - ((basePrice * discountForSet) / TOTAL_PERCENTAGE);
		calculatedPrice += discountedPriceForSet;
		return calculatedPrice;
	}
}
