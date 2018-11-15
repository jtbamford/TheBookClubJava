package com.qa.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

// this is where we will define our objects from the table book, define these quantities in Java

@Entity
public class Book {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long bookID;
	private String title;
	private String author;

	public Book() {

	}

	public Book(String title, String author, BookOwnership bookownership) {
		this.title=title;
		this.author=author;
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
	
	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}
	
}
