package com.qa.service;

import java.util.Collection;

import com.qa.persistence.Book;
import com.qa.persistence.BookOwnership;
import com.qa.persistence.User;

public interface BookService {
	
	
	String getAllBooks();
	
	// method gets the books for an individual user
	String getBooks(Long userID);
	
	String getBookOwnership(Long bookownershipID);
	
	Collection<Book> getAllBooksAsObjects();
	
	// method adds a book to database (independent of user)
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
