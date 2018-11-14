package com.qa.persistence;

import java.util.Collection;

public interface BookRepository {

	// interface not strictly necessary since only one implementation defined
	
	String getAllBooks();
	
	String getAllBookOwnerships();
	
	String getAllUsers();
	
	String getBookOwnership(Long bookownershipID);
	
	String getAllBookOwnershipsForUser(Long userID);
	
	String getUser(Long userID);
	
	String getUserByUsername(String username);

	Collection<Book> getAllBooksAsObjects();
	
	Collection<User> getAllUsersAsObjects();
	
	Collection<BookOwnership> getAllBookOwnershipsAsObjects();
	
	// method adds a book to database (independent of user)
	// only implement on first time any user wants to store this book (put this 'if' in service layer)
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
