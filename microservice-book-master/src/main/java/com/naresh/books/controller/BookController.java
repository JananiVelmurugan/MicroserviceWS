package com.naresh.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.books.dto.UserDTO;
import com.naresh.books.external.UserServiceClient;
import com.naresh.books.model.Book;
import com.naresh.books.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserServiceClient userServiceClient;
	
	@GetMapping
	public List<Book> list() {
		return bookService.list();
	}

	@PostMapping
	public ResponseEntity<Void> addBook(@RequestHeader("Authorization") String authorizationToken , @RequestBody Book book) {
		System.out.println("Add Book :" + book);
		
		UserDTO user = userServiceClient.getCurrentUser();
		System.out.println("UserDTO:" + user);
		if (user != null ) {
			book.setCreatedBy(user.getId());
			bookService.save(book);
			return new ResponseEntity<>(HttpStatus.CREATED);
		
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}

	@GetMapping("/{bookId}")
	public Book findOne(@PathVariable("bookId") Long bookId) {
		return bookService.findOne(bookId);
	}
}
