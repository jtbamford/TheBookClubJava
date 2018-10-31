package com.qa.persistence;

public interface BookService {

	String getAllBooks();
	
	// method gets the books for an individual user
	String getBooks(Long id);

	// method adds book for an individual user
	String addBook(String title, String author, Long id);

	String deleteAccount(Long id);
	
}
