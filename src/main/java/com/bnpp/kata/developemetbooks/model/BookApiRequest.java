package com.bnpp.kata.developemetbooks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
