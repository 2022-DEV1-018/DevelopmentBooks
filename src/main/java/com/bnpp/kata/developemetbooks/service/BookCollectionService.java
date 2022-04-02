package com.bnpp.kata.developemetbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bnpp.kata.developemetbooks.exception.BooksApiException;
import com.bnpp.kata.developemetbooks.model.BookApiRequest;
import com.bnpp.kata.developemetbooks.model.BooksEnum;

@Service
public class BookCollectionService {

	public List<Object> getAllBooks() {
		return BooksEnum.getAllBooks();
	}

	public void validateBooksCollection(List<BookApiRequest> bookInputList) throws BooksApiException {
		for (BookApiRequest bookApiRequest : bookInputList) {
			BooksEnum.getBookById(bookApiRequest.getBookId());
		}
	}
}
