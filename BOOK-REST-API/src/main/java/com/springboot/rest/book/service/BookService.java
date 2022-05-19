package com.springboot.rest.book.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.springboot.rest.book.model.Book;
import com.springboot.rest.book.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public List<Book> getAllBooks(){
		 List<Book> books = (List<Book>)bookRepository.findAll();
		return books;
	}
	public Book getBook(int id) {
		Book book = null;
		try {
			 book = this.bookRepository.findById(id);
		}
		catch (NoSuchElementException noSuchElementException) {
			
		}
		
		return book;
	}
	
	public Book addBook(Book book) {
		book = this.bookRepository.save(book);
		return book;
	}
	
	public void deleteBookById (int id) {
		this.bookRepository.deleteById(id);
		
	}
	public void deleteAllBooks() {
		this.bookRepository.deleteAll();
	}
	@Transactional
	public Book updateBook(Book book) {
		
		this.hibernateTemplate.saveOrUpdate(book);
		return book;
	}
	
}
