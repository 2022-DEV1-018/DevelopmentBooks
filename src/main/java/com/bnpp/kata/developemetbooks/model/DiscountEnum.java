package com.bnpp.kata.developemetbooks.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum DiscountEnum {

	ZERO_DISCOUNT(1, 0.0), FIVE_DISCOUNT(2, 5.0), TEN_DISCOUNT(3, 10.0), TWENTY_DISCOUNT(4, 20.0),
	TWENTY_FIVE_DISCOUNT(5, 25.0);

	private Integer bookCount;
	private Double bookDiscount;

	DiscountEnum(Integer bookCount, Double bookDiscount) {
		this.bookCount = bookCount;
		this.bookDiscount = bookDiscount;
	}

	public static Map<Integer, Double> getDiscounts() {
		Map<Integer, Double> discounts = new HashMap<>();

		for (DiscountEnum discount : DiscountEnum.values()) {
			discounts.put(discount.bookCount, discount.bookDiscount);
		}
		return discounts;
	}
}
