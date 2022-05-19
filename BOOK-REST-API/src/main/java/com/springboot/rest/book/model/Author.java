package com.springboot.rest.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authodId;
	private String firstName;
	private String lastName;
	@OneToOne(mappedBy = "bookAuthor")
	@JsonBackReference
	private Book book;
	
	public Author(int authodId, String firstName, String lastName, Book book) {
		super();
		this.authodId = authodId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Author [authodId=" + authodId + ", firstName=" + firstName + ", lastName=" + lastName + ", book=" + book
				+ "]";
	}

	public int getAuthodId() {
		return authodId;
	}

	public void setAuthodId(int authodId) {
		this.authodId = authodId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
