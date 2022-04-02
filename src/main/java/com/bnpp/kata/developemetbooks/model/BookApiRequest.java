package com.bnpp.kata.developemetbooks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookApiRequest implements Comparable<BookApiRequest> {
	private Integer bookId;
	private Integer quantity;

	@Override
	public int compareTo(BookApiRequest arg) {
		if (getQuantity() == null || arg.getQuantity() == null) {
			return 0;
		}
		return getQuantity().compareTo(arg.getQuantity());
	}
}
