package com.bnpp.kata.developemetbooks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookApiResponse {
	private Double discountedPrice;
	private Double bookPrice;
	private Integer totalBooks;
}
