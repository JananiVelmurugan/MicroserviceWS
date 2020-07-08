package com.naresh.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naresh.books.dao.BookRepository;
import com.naresh.books.model.Book;

@Service
@Transactional
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> list(){
		return bookRepository.list();
	}

	public void save(Book book) {

		bookRepository.save(book);
	}
	
	public Book findOne(Long bookId) {
		return bookRepository.findOne(bookId);
	}
}
