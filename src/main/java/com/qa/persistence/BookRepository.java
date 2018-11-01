package com.qa.persistence;

public interface BookRepository {

	// these methods have come from BookService, and are used to add books to a list in Java so we can do things with them
	// (as opposed to adding etc. to the database)
	
	String getAllBooks();
	
	// method gets the books for an individual user
	String getBooks(Long id);

	// method adds book for an individual user
	String addBook(String title, String author, Long id);

	String deleteAccount(Long id);
	
}
