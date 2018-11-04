package com.qa.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;

// this is where we will define our objects from the table library
// define these quantities in Java

@Entity @IdClass(LibraryID.class)
public class Library {
	
	private byte rating;
	private String review;
	@JoinColumn(name="bookID")
	@Id
	private Book book;	
	@JoinColumn(name="userID")
	@Id
	private User user;

	public Library() {

	}

	public Library(byte rating, String review, Book book, User user) {
		this.rating=rating;
		this.review=review;
		this.book=book;
		this.user=user;
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
