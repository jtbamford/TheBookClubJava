package com.qa.persistence;

import java.util.Collection;

public interface BookRepository {

	// interface not strictly necessary since only one implementation defined
	
	String getAllBooks();
	
	// method gets the books for an individual user
	String getBooks(Long userID);

	Collection<Book> getAllBooksAsObjects();
	
	// method adds a book to database (independent of user)
	// only implement on first time any user wants to store this book (put this 'if' in service layer)
	String addBook(String book);
	
	// method adds book for an individual user
	String addBookForUser(String bookownership);

	String deleteUser(Long userID);

	String addUser(String username);
	
	// delete book for individual user
	String deleteBookForUser(Long bookownershipID);
	
	String updateUser(String user, Long userID);
	
	Book retrieveBook(Long bookID);
	
	User retrieveUser(Long userID);
	
	BookOwnership retrieveBookOwnership(Long bookownershipID);
	
}
