package com.bnpp.kata.developemetbooks.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bnpp.kata.developemetbooks.model.BookApiRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DevelopmentBooksControllerTest {

	private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private MockMvc mvc;

	@Test
	public void getAllBooks() throws Exception {
		
		mvc.perform(get("/books/getBooks").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(
						"[{\"id\":1,\"title\":\"Clean Code\",\"year\":2008,\"author\":\"Robert Martin\"},{\"id\":2,\"title\":\"The Clean Coder\",\"year\":2011,\"author\":\"Robert Martin\"},{\"id\":3,\"title\":\"Clean Architecture\",\"year\":2017,\"author\":\"Robert Martin\"},{\"id\":4,\"title\":\"Test-Driven Development By Example\",\"year\":2003,\"author\":\"Kent Beck\"},{\"id\":5,\"title\":\"Working Effectively With Legacy Code\",\"year\":2004,\"author\":\"Michael C. Feathers\"}]"));
	}

	@Test
	public void calculateBooksPrice() throws Exception {
		
		List<BookApiRequest> bookApiRequestList = new ArrayList<>();
		BookApiRequest bookApiRequest = new BookApiRequest();
		bookApiRequest.setBookId(1);
		bookApiRequest.setQuantity(1);
		bookApiRequestList.add(bookApiRequest);
	    bookApiRequest = new BookApiRequest();
		bookApiRequest.setBookId(2);
		bookApiRequest.setQuantity(1);
		bookApiRequestList.add(bookApiRequest);

		mvc.perform(post("/books/calculateBookPrice").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(bookApiRequestList)))
				.andExpect(status().isOk()).andExpect(content().json("{\n" + "    \"discountedPrice\": 95.0,\n"
						+ "    \"bookPrice\": 100.0,\n" + "    \"totalBooks\": 2\n" + "}"));
	}

}