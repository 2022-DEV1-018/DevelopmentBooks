package com.bnpp.kata.developemetbooks.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bnpp.kata.developemetbooks.model.BookApiRequest;
import com.bnpp.kata.developemetbooks.model.DiscountEnum;

public class CalculateBooksPriceService {

	private static final int BOOK_PRICE = 50;
	private static final double TOTAL_PERCENTAGE = 100.0;
	private int maxDiscountSet;

	public double calculateBooksPrice(List<BookApiRequest> bookApiRequestList) {
		maxDiscountSet = bookApiRequestList.size();
		Collections.sort(bookApiRequestList, Collections.reverseOrder());
		List<Integer> inputBookIds = getBookIdList(bookApiRequestList);
		List<List<Integer>> defaultCombinationSets = getDefaultBooksCombination(inputBookIds);
		List<List<Integer>> otherPossibleCombinationSets = getBestCombinationSet(new ArrayList<>(inputBookIds));

		double totalPriceNormalSets = getBooksPrice(defaultCombinationSets);
		if (maxDiscountSet > 3) {
			double totalPriceSmallestSets = getBooksPrice(otherPossibleCombinationSets);
			return Math.min(totalPriceNormalSets, totalPriceSmallestSets);
		}

		return totalPriceNormalSets;
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

	private List<List<Integer>> getBestCombinationSet(List<Integer> bookLists) {
		List<Integer> bookList = bookLists;
		List<List<Integer>> booksCombinationSet = new ArrayList<>();
		List<Integer> childBookList;
		for (int i = 0; i < maxDiscountSet; i++) {
			if (!bookList.isEmpty()) {
				childBookList = new ArrayList<>();
				findBestBooksCombination(bookList, childBookList);
				booksCombinationSet.add(childBookList);
			}
		}
		return booksCombinationSet;
	}

	private void findBestBooksCombination(List<Integer> bookIdList, List<Integer> childBookList) {
		int index = 0;
		while (bookIdList.size() > index) {
			if (!(childBookList.contains(bookIdList.get(index))) && childBookList.size() < maxDiscountSet - 1) {
				childBookList.add(bookIdList.get(index));
				bookIdList.remove(index);
				index = index - 1;
			}
			index++;
		}
	}
}
