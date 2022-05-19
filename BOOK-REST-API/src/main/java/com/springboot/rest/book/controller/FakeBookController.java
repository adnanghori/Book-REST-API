//package com.springboot.rest.book.controller;
//
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.springboot.rest.book.model.Book;
//import com.springboot.rest.book.service.FakeBookService;
//
//@RestController
//public class FakeBookController {
//	@Autowired
//	private FakeBookService fakeBookService;
//	@GetMapping(value = "/books")
//	public ResponseEntity<List<Book>> getBooks() {
////		Book book = new Book();
////		book.setBook_id(101);
////		book.setBookName("Spring Boot REST");
////		book.setBookAuthor("Kathy Sierra");
//		List<Book> allBooks = this.fakeBookService.getAllBooks();
//		if(allBooks.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.of(Optional.of(allBooks));
//	}
//	@GetMapping("/book/{id}")
//	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
//		Book book = this.fakeBookService.getBook(id);
//		if(book==null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//			
//		}
//		return ResponseEntity.of(Optional.of(book));
//	}
//	@PostMapping("/book")
//	public Book addBook(@RequestBody Book book) {
//		Book addBook = this.fakeBookService.addBook(book);
//		return addBook;
//	}
//	@DeleteMapping("/book/{id}")
//	public Book deleteBook(@PathVariable("id") int id)
//	{
//		 Book book = this.fakeBookService.deleteBookById(id);
//		return book;
//	}
//	
//	@PutMapping("/book/{id}")
//	public Book updateBook(@RequestBody Book book , @PathVariable("id") int id) {
//		this.fakeBookService.updateBook(book, id);
//		return book;
//	}
//	
//}
