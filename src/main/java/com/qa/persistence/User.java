package com.qa.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// this is where we will define our objects from the table user
// define these quantities in Java


@Entity
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long userID;
	private String username;

	public User() {

	}

	public User(String username) {
		this.username=username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}
	
}
