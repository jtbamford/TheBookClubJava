package com.qa.service;

import java.util.Collection;

import com.qa.persistence.Book;
import com.qa.persistence.BookOwnership;
import com.qa.persistence.User;

public interface BookService {
	
	
	String getAllBooks();
	
	String getAllBookOwnerships();
	
	String getAllUsers();
	
	// method gets the books for an individual user
	String getBooks(Long userID);
	
	String getBookOwnership(Long bookownershipID);
	
	String getUser(Long userID);
	
	String getUserByUsername(String username);
	
	Collection<Book> getAllBooksAsObjects();
	
	Collection<User> getAllUsersAsObjects();
	
	Collection<BookOwnership> getAllBookOwnershipsAsObjects();
	
	// method adds a book to database (independent of user)
	String addBook(String book);

	// method adds book for an individual user
	String addBookForUser(String bookownership);

	String deleteUser(Long userID);
	
	String addUser(String user);
	
	// delete book for individual user
	String deleteBookForUser(Long bookownershipID);
	
	String updateUser(String user, Long userID);
	
	Book retrieveBook(Long bookID);
	
	User retrieveUser(Long userID);
	
	BookOwnership retrieveBookOwnershipByID(Long bookownershipID);
	
	User retrieveUserFromUsername(String username);
	
	BookOwnership retrieveBookOwnership(String username, String title, String author);
	
}
