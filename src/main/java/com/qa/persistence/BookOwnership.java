package com.qa.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

// this is where we will define our objects from the table bookownership
// define these quantities in Java

@Entity
public class BookOwnership {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long bookownershipID;
	private byte rating;
	private String review;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="bookID")
	private Book book;
	@JoinColumn(name="userID")
	private Long userID;

	public BookOwnership() {

	}

	public BookOwnership(byte rating, String review, Book book, Long userID) {
		this.rating=rating;
		this.review=review;
		this.book=book;
		this.userID=userID;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
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



}
