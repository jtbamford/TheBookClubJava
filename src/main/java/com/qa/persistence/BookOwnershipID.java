package com.qa.persistence;

import
java.io.Serializable;

public class BookOwnershipID implements Serializable {

	private Book book;
	private User user;

	public BookOwnershipID() {
		
	}
	
	public BookOwnershipID(Book book, User user) {
		this.book=book;
		this.user=user;
	}
	
	public Book getBook() {
		return book;
	}

	public User getUser() {
		return user;
	}
	
	// need to now override hashcode and equals methods.
	// for equals method, presumably if the userID and bookID of
	// a bookownership object are equal the objects are equal
	
}
