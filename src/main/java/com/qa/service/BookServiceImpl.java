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
		
		public String getBookOwnership(Long bookownershipID) {
			return repo.getBookOwnership(bookownershipID);
		}
		
		public Collection<Book> getAllBooksAsObjects() {
			return repo.getAllBooksAsObjects();
		}
		
		public String addBook(String book) {
			Book abook = util.getObjectForJSON(book, Book.class);
			if(repo.getAllBooksAsObjects().contains(abook)) {
				return "Book already in database";
			} else {
			return repo.addBook(book);
			}
		}
	
		public String addBookForUser(String bookownership) {
			return repo.addBookForUser(bookownership);
		}

		public String deleteUser(Long userID) {
			return repo.deleteUser(userID);
		}

		public String addUser(String username) {
			return repo.addUser(username);
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
		
		public BookOwnership retrieveBookOwnership(Long bookownershipID) {
			return repo.retrieveBookOwnership(bookownershipID);
		}
		
}


