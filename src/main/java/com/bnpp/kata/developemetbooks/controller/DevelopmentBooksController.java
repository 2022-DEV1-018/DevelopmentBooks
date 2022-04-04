package com.bnpp.kata.developemetbooks.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.kata.developemetbooks.exception.BooksApiException;
import com.bnpp.kata.developemetbooks.model.BookApiRequest;
import com.bnpp.kata.developemetbooks.service.BookCollectionService;
import com.bnpp.kata.developemetbooks.service.CalculateBooksPriceService;

@RestController
public class DevelopmentBooksController {
	private BookCollectionService bookCollectionService;
	private CalculateBooksPriceService calculateBooksPriceService;

	public DevelopmentBooksController(BookCollectionService bookCollectionService,
			CalculateBooksPriceService calculateBooksPriceService) {
		this.bookCollectionService = bookCollectionService;
		this.calculateBooksPriceService = calculateBooksPriceService;
	}

	@GetMapping("/books/getBooks")
	public ResponseEntity<Object> getListOfBooks() {
		return ResponseEntity.ok(bookCollectionService.getAllBooks());
	}

	@PostMapping(path = "/books/calculateBookPrice", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> calculateBooksPrice(@RequestBody List<BookApiRequest> bookList) {
		try {
			bookCollectionService.validateBooksCollection(bookList);
		} catch (BooksApiException booksApiException) {
			return ResponseEntity.badRequest().body(booksApiException.getMessage());
		}
		return ResponseEntity.ok(calculateBooksPriceService.calculateBooksPrice(bookList));
	}
}