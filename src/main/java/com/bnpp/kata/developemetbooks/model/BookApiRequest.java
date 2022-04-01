package com.bnpp.kata.developemetbooks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookApiRequest {

	private Integer bookId;
	private Integer quantity;
}
