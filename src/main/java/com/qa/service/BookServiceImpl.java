package com.qa.service;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.Query;

import com.qa.persistence.Book;
import com.qa.persistence.BookOwnership;
import com.qa.persistence.BookRepository;
import com.qa.persistence.User;
import com.qa.util.JSONUtil;
import java.util.Collection;


public class BookServiceImpl implements BookService {
	
	// in this class I need to write business rule saying only use addBook() to add book to Book DB the
	// first time this book is used in my system, else just use addBookForUser() to add the book to that
	// individual users' library only
		
		@Inject
		private BookRepository repo;
		
		@Inject
		private JSONUtil util;
		
		public String getAllBooks() {
			return repo.getAllBooks();
		}
		
		public String getBooks(Long userID) {
		return repo.getBooks(userID);
		}
		
		public String getBookOwnership(String username, String title, String author) {
			return repo.getBookOwnership(username, title, author);
		}
		
		public String getUser(String username) {
			return repo.getUser(username);
		}
		
		public Collection<Book> getAllBooksAsObjects() {
			return repo.getAllBooksAsObjects();
		}
		
		public Collection<User> getAllUsersAsObjects() {
			return repo.getAllUsersAsObjects();
		}
		
		public  Collection<BookOwnership> getAllBookOwnershipsAsObjects() {
			return repo.getAllBookOwnershipsAsObjects();
		}
		
		public String addBook(String book) {
		//	Book abook = util.getObjectForJSON(book, Book.class);
		//	if(repo.getAllBooksAsObjects().contains(abook)) {
		//		return "Book already in database";
		//	} else {
			return repo.addBook(book);
		//	}
		}
	
		public String addBookForUser(String bookownership) {
		//	BookOwnership abookownership = util.getObjectForJSON(bookownership, BookOwnership.class);
		//	if(repo.getAllBookOwnershipsAsObjects().contains(abookownership)) {
		//		return "Book already in your Library";
		//	} else {
			return repo.addBookForUser(bookownership);
		//	}
		}

		public String deleteUser(Long userID) {
			return repo.deleteUser(userID);
		}

		// create business rule so username must be unique
		
		public String addUser(String user) {
		//	User auser = util.getObjectForJSON(user, User.class);
		//	if(repo.getAllUsersAsObjects().contains(auser)) {
		//		return "username already in use, choose another";
		//	} else {
			return repo.addUser(user);
		//	}
		}
		
		public String deleteBookForUser(Long bookownershipID) {
			return repo.deleteBookForUser(bookownershipID);
		}
		
		public String updateUser(String user, Long userID) {
			return repo.updateUser(user, userID);
		}
		
		public Book retrieveBook(Long bookID) {
			return repo.retrieveBook(bookID);
		}
		
		public User retrieveUser(Long userID) {
			return repo.retrieveUser(userID);
		}
		
		public BookOwnership retrieveBookOwnershipByID(Long bookownershipID) {
			return repo.retrieveBookOwnershipByID(bookownershipID);
		}
		
		public User retrieveUserFromUsername(String username) {
			return repo.retrieveUserFromUsername(username);
		}
		
		public BookOwnership retrieveBookOwnership(String username, String title, String author) {
			return repo.retrieveBookOwnership(username, title, author);
		}
		
}


