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
		
		public String getAllBookOwnerships() {
			return repo.getAllBookOwnerships();
		}
		
		public String getAllUsers() {
			return repo.getAllUsers();
		}
		
		public String getBookOwnership(Long bookownershipID) {
			return repo.getBookOwnership(bookownershipID);
		}
		
		public String getAllBookOwnershipsForUser(Long userID) {
			return repo.getAllBookOwnershipsForUser(userID);
		}
		
		public String getUser(Long userID) {
			return repo.getUser(userID);
		}
		
		public String getUserByUsername(String username) {
			return repo.getUserByUsername(username);
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
			Book abook = util.getObjectForJSON(book, Book.class);
			if(repo.getAllBooksAsObjects().stream().filter(i->abook.getAuthor().equals(i.getAuthor()))
					.filter(i->abook.getTitle().equals(i.getTitle())).count()!=0) {
				return "{\"message\": \"book already in Database\"}";
			} else {
			return repo.addBook(book);
			}
		}
	
		public String addBookForUser(String bookownership) {
			BookOwnership abookownership = util.getObjectForJSON(bookownership, BookOwnership.class);
			if(repo.getAllBookOwnershipsAsObjects().stream().filter(i->abookownership.getBook().getAuthor().equals(i.getBook().getAuthor()))
					.filter(i->abookownership.getBook().getTitle().equals(i.getBook().getTitle())).filter(i->abookownership.getUserID()
							.equals(i.getUserID())).count()!=0) {
				return "{\"message\": \"book already in library\"}";
			} else if(abookownership.getRating()>5 || abookownership.getRating()<1) {
				return "{\"message\": \"book rating not in range\"}";
			} else {
			return repo.addBookForUser(bookownership);
			}
		}

		public String deleteUser(Long userID) {
			return repo.deleteUser(userID);
		}

		// create business rule so username must be unique
		
		public String addUser(String user) {
			User auser = util.getObjectForJSON(user, User.class);
			if(repo.getAllUsersAsObjects().stream().filter(i->auser.getUsername().equals(i.getUsername())).count()!=0) {
				return "{\"message\": \"create a unique username\"}";
			} else {
			return repo.addUser(user);
			}
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


