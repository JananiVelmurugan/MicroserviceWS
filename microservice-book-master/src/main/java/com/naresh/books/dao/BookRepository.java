package com.naresh.books.dao;

	
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.naresh.books.model.Book;


@Repository
public class BookRepository {

	@PersistenceContext
	private EntityManager em;

	public List<Book> list() {

		List<Book> resultList = em.createQuery("from " + Book.class.getName(), Book.class).getResultList();
		em.close();

		return resultList;
	}

	public void save(Book book) {

		em.persist(book);
		em.close();
	}
	
	public Book findOne(Long bookId) {
		
		Book book = em.createQuery("from "+ Book.class.getName() + " b where id= :bookId", Book.class).setParameter("bookId", bookId).getSingleResult();
		em.close();
		return book;
	}

}
