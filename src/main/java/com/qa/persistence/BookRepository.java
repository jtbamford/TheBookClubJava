package com.qa.persistence;

public interface BookRepository {

	// interface not strictly necessary since only one implementation defined
	
	String getAllBooks();
	
	// method gets the books for an individual user
	String getBooks(Long userID);

	// method adds book for an individual user
	String addBook(String title, String author, Long userID);

	String deleteUser(Long userID);

	String addUser(String username);
	
	// delete book for individual user
	String deleteBook(Long bookID, Long userID);
}
