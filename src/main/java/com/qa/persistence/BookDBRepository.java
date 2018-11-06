package com.qa.persistence;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.util.JSONUtil;

// this class performs a database transaction (SQL insert)
// need to remember to change my configuration to that of an SQL DB

@Transactional(SUPPORTS)
public class BookDBRepository implements BookRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllBooks() {
		Query query = manager.createQuery("Select a FROM Book a");
		Collection<Book> books = (Collection<Book>) query.getResultList();
		return util.getJSONForObject(books);
	}

	@Transactional(REQUIRED)
	public String addBook(String title, String author, Long userID) {
		Book abook = util.getObjectForJSON(booktoadd, Book.class);
		manager.persist(abook);
		return "{\"message\": \"book has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String addUser(String username) {
		User auser = util.getObjectForJSON(username, User.class);
		manager.persist(auser);
		return "{\"message\": \"user has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteBook(Long bookID, Long userID) {
		Account accountInDB = retrieveClassroom(classroomID);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteUser(Long userID) {
		User userInDB = retrieveUser(userID);
		if (userInDB != null) {
			manager.remove(userInDB);
		}
		return "{\"message\": \"trainee sucessfully deleted\"}";
	}
	

	public Book retrieveBook(Long bookID) {
		return manager.find(Book.class, bookID);
	}
	
	public User retrieveUser(Long userID) {
		return manager.find(User.class, userID);
	}
	

	@Transactional(REQUIRED)
	public String updateUser(String user, Long userID) {
		User auser = util.getObjectForJSON(user, User.class);
		User userold=retrieveUser(userID);
		userold.setUserID(auser.getUserID());
		userold.setUsername(auser.getUsername());
		return "{\"message\": \"account has been sucessfully updated\"}";
	}

}
