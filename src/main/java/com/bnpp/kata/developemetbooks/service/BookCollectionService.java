package com.bnpp.kata.developemetbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bnpp.kata.developemetbooks.model.BooksEnum;

@Service
public class BookCollectionService {

	public List<Object> getAllBooks() {
		return BooksEnum.getAllBooks();
	}
}
