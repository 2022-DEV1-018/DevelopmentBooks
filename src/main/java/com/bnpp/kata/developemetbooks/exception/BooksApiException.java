package com.bnpp.kata.developemetbooks.exception;

public class BooksApiException extends Exception {

	private static final long serialVersionUID = 1582625567260101798L;
	private final String errorMessage;

	public BooksApiException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorMessage;
	}
}