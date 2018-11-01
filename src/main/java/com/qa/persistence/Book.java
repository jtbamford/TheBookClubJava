package com.qa.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// this is where we will define our objects from the table book, define these quantities in Java

@Entity
public class Book {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int bookID;
	private String title;
	private String author;

	public Book() {

	}

	public Book(int bookID, String title, String author) {
		this.bookID = bookID;
		this.setTitle(title);
		this.setAuthor(author);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
}
