package com.qa.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;

// this is where we will define our objects from the table bookownership
// define these quantities in Java

@Entity
public class BookOwnership {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long bookownershipID;
	private byte rating;
	private String review;
	@JoinColumn(name="bookID")
	private Book book;	
	@JoinColumn(name="userID")
	private User user;

	public BookOwnership() {

	}

	public BookOwnership(Long bookownershipID, byte rating, String review, Book book, User user) {
		this.bookownershipID=bookownershipID;
		this.rating=rating;
		this.review=review;
		this.book=book;
		this.user=user;
	}
	
	public Long getBookownershipID() {
		return bookownershipID;
	}

	public void setBookownershipID(Long bookownershipID) {
		this.bookownershipID = bookownershipID;
	}

	public byte getRating() {
		return rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
