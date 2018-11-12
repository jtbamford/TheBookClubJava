package com.qa.persistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name="bookID")
	private Long bookID;	
	@JoinColumn(name="userID")
	private Long userID;

	public BookOwnership() {

	}

	public BookOwnership(Long bookownershipID, byte rating, String review, Long bookID, Long userID) {
		this.bookownershipID=bookownershipID;
		this.rating=rating;
		this.review=review;
		this.bookID=bookID;
		this.userID=userID;
	}
	
	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
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
