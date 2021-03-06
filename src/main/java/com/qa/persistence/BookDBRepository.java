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
// need to change database so no longer use a composite ID

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
	
	public String getAllBookOwnerships() {
		Query query = manager.createQuery("Select a FROM BookOwnership a");
		Collection<BookOwnership> bookownerships = (Collection<BookOwnership>) query.getResultList();
		return util.getJSONForObject(bookownerships);
	}
	
	public String getAllUsers() {
		Query query = manager.createQuery("Select a FROM User a");
		Collection<User> users = (Collection<User>) query.getResultList();
		return util.getJSONForObject(users);
	}
	
	public  Collection<Book> getAllBooksAsObjects() {
		Query query = manager.createQuery("Select a FROM Book a");
		Collection<Book> books = (Collection<Book>) query.getResultList();
		return books;
	}
	
	public  Collection<User> getAllUsersAsObjects() {
		Query query = manager.createQuery("Select a FROM User a");
		Collection<User> users = (Collection<User>) query.getResultList();
		return users;
	}
	
	public  Collection<BookOwnership> getAllBookOwnershipsAsObjects() {
		Query query = manager.createQuery("Select a FROM BookOwnership a");
		Collection<BookOwnership> bookownerships = (Collection<BookOwnership>) query.getResultList();
		return bookownerships;
	}
	
	public String getBookOwnership(Long bookownershipID) { 
		BookOwnership abookownershipinDB = retrieveBookOwnershipByID(bookownershipID);
		return util.getJSONForObject(abookownershipinDB);
	}
	
	public String getAllBookOwnershipsForUser(Long userID) {
		Query query = manager.createQuery("Select a FROM BookOwnership a where userID="+userID);
		Collection<BookOwnership> bookownerships = (Collection<BookOwnership>) query.getResultList();
		return util.getJSONForObject(bookownerships);
	}
	
	public String getUser(Long userID) { 
		User auserinDB = retrieveUser(userID);
		return util.getJSONForObject(auserinDB);
	}
	
	public String getUserByUsername(String username) {
		User auserinDB = retrieveUserFromUsername(username);
		return util.getJSONForObject(auserinDB);
	}
	
	@Transactional(REQUIRED)
	public String addBook(String booktoadd) {
		Book abook = util.getObjectForJSON(booktoadd, Book.class);
		manager.persist(abook);
		return "{\"message\": \"book has been successfully added to Database\"}";
	}
	
	@Transactional(REQUIRED)
	public String addBookForUser(String bookownershiptoadd) {
		BookOwnership abookownership = util.getObjectForJSON(bookownershiptoadd, BookOwnership.class);
		manager.persist(abookownership);
		return "{\"message\": \"book has been successfully added to your Library\"}";
	}
	
	
	@Transactional(REQUIRED)
	public String addUser(String user) {
		User auser = util.getObjectForJSON(user, User.class);
		manager.persist(auser);
		return "{\"message\": \"user has been successfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteBookForUser(Long bookownershipID) {
		BookOwnership abookownershipinDB = retrieveBookOwnershipByID(bookownershipID);
		if (abookownershipinDB != null) {
			manager.remove(abookownershipinDB);
		}
		return "{\"message\": \"book has been successfully removed from your Library\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteUser(Long userID) {
		User userInDB = retrieveUser(userID);
		if (userInDB != null) {
			manager.remove(userInDB);
		}
		return "{\"message\": \"user successfully deleted\"}";
	}
	

	public Book retrieveBook(Long bookID) {
		return manager.find(Book.class, bookID);
	}
	
	public User retrieveUser(Long userID) {
		return manager.find(User.class, userID);
	}
	
	public BookOwnership retrieveBookOwnershipByID(Long bookownershipID) {
		return manager.find(BookOwnership.class, bookownershipID);
	}
	
	public User retrieveUserFromUsername(String username) {
		Collection<User> users = getAllUsersAsObjects();
		User user = users.stream().filter(i->i.getUsername().equalsIgnoreCase(username)).findAny().get();
		return user;
	}

	@Transactional(REQUIRED)
	public String updateUser(String user, Long userID) {
		User auser = util.getObjectForJSON(user, User.class);
		User userold=retrieveUser(userID);
		userold.setUserID(auser.getUserID());
		userold.setUsername(auser.getUsername());
		return "{\"message\": \"user has been sucessfully updated\"}";
	}
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
