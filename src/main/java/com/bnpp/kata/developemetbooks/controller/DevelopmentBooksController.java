package com.bnpp.kata.developemetbooks.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnpp.kata.developemetbooks.service.BookCollectionService;

@RestController
public class DevelopmentBooksController {
	private BookCollectionService bookCollectionService;

	public DevelopmentBooksController(BookCollectionService bookCollectionService) {
		this.bookCollectionService = bookCollectionService;
	}

	@GetMapping("/books/getBooks")
	public ResponseEntity<?> getListOfBooks() {
		return ResponseEntity.ok(bookCollectionService.getAllBooks());
	}
}