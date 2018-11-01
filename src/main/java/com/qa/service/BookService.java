package com.qa.service;

public interface BookService {
	
	// these methods are adding, deleting, getting etc. the books from a list in Java, not from the database
	// using these list we can then act on these books to write our business rules (define the list in BookServiceImpl)
	
	String getAllBooks();
	
	// method gets the books for an individual user
	String getBooks(Long id);

	// method adds book for an individual user
	String addBook(String title, String author, Long id);

	String deleteAccount(Long id);
	
}
