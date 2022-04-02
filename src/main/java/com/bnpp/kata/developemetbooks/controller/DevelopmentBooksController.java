package com.bnpp.kata.developemetbooks.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<?> getListOfBooks() {
		return ResponseEntity.ok(bookCollectionService.getAllBooks());
	}

	@PostMapping(path = "/books/calculateBookPrice", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> calculateBooksPrice(@RequestBody List<BookApiRequest> bookList) {
		try {
			bookCollectionService.validateBooksCollection(bookList);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(calculateBooksPriceService.calculateBooksPrice(bookList));
	}
}