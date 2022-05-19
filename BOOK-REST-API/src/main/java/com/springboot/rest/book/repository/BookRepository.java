package com.springboot.rest.book.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.rest.book.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	public Book findById(int id);
	
}
