package com.bnpp.kata.developemetbooks.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.ImmutableMap;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BooksEnum {

	CLEAN_CODE(1, "Clean Code", "Robert Martin", 2008), THE_CLEAN_CODER(2, "The Clean Coder", "Robert Martin", 2011),
	CLEAN_ARCHITECTURE(3, "Clean Architecture", "Robert Martin", 2017),
	TEST_DRIVEN_DEVELOPMENT(4, "Test-Driven Development By Example", "Kent Beck", 2003),
	WORKING_WITH_LEGACY_CODE(5, "Working Effectively With Legacy Code", "Michael C. Feathers", 2004);

	private int id;
	private String title;
	private String author;
	private int year;

	BooksEnum(int id, String title, String author, int year) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public static List<Object> getAllBooks() {
		return Arrays.stream(BooksEnum.values())
				.map(book -> new HashMap<>(
						ImmutableMap.of("id", book.id, "title", book.title, "author", book.author, "year", book.year)))
				.collect(Collectors.toList());
	}
}