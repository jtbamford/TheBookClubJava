package com.qa.service;

public interface BookService {
	
	
	String getAllBooks();
	
	// method gets the books for an individual user
	String getBooks(Long userID);

	// method adds book for an individual user
	String addBook(String title, String author, Long userID);

	String deleteUser(Long userID);
	
	String addUser(String username);
	
	// delete book for individual user
	String deleteBook(Long bookID, Long userID);
	
	String updateUser(String user, Long userID);
	
}
