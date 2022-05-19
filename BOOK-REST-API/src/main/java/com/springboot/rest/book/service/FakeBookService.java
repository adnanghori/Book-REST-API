//package com.springboot.rest.book.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.stream.Collectors;
//
//
//import org.springframework.stereotype.Service;
//
//import com.springboot.rest.book.model.Book;
//@Service
//public class FakeBookService {
//	private static List<Book> list = new ArrayList<>();
//	static {
//		list.add(new Book(101,"Python","Think Python"));
//		list.add(new Book(102,"Java","Bert"));
//		list.add(new Book(103,"Head First Java","kathy"));
//		list.add(new Book(104,"OCJP","Khalid A Mughal"));
//	}
//	
//	public List<Book> getAllBooks(){
//		return list;
//	}
//	public Book getBook(int id) {
//		Book book = null;
//		try {
//			 book = list.stream().filter(t ->t.getBookId()==id).findFirst().get();
//		}
//		catch (NoSuchElementException noSuchElementException) {
//			
//		}
//		
//		return book;
//	}
//	
//	public Book addBook(Book book) {
//		list.add(book);
//		return book;
//	}
//	
//	public Book deleteBookById (int id) {
//		Book book = list.stream().filter(t -> t.getBookId()==id).findFirst().get();		
//		list.remove(book);
//		return book;
//	}
//	public void updateBook(Book book , int id) {
//		
//		list = list.stream().map(b->{
//			if(b.getBookId()==id) {
//				b.setBookName(book.getBookName());
//				b.setBookAuthor(book.getBookAuthor());
//			}
//			return b;
//			
//		}).collect(Collectors.toList());
//		
//		
//	}
//	
//}
