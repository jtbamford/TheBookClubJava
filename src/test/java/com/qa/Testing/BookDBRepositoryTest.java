package com.qa.Testing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.Book;
import com.qa.persistence.BookDBRepository;
import com.qa.persistence.BookOwnership;
import com.qa.persistence.User;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class BookDBRepositoryTest {
	
	@InjectMocks
	private BookDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_BOOK_RETURN = "[{\"title\":\"title_one\",\"author\":\"author_one\"}]";
	
	private static final String MOCK_USER_RETURN = "[{\"username\":\"user_one\"}]";
	
	private static final String MOCK_BOOKOWNERSHIP_RETURN = "[{\"rating\":1,\"review\":\"review_one\",\"book\":"
			+ "{\"title\":\"title_three\",\"author\":\"author_three\"},\"userID\":1}]";

	private static final String MOCK_BOOK_INPUT = "{\"title\":\"title_two\",\"author\":\"author_two\"}";
	
	private static final String MOCK_USER_INPUT = "{\"username\":\"user_one\"}";
	
	private static final String MOCK_USER = "{\"username\":\"user_two\"}";
	
	private static final String MOCK_BOOKOWNERSHIP_INPUT = "{\"rating\":1,\"review\":\"review_one\",\"book\":"
			+ "{\"title\":\"title_three\",\"author\":\"author_three\"},\"userID\":1}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllBooks() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("title_one", "author_one"));
		Mockito.when(query.getResultList()).thenReturn(books);
		Assert.assertEquals(MOCK_BOOK_RETURN, repo.getAllBooks());
	}
	
	@Test
	public void testGetAllBookOwnerships() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<BookOwnership> bookownerships = new ArrayList<BookOwnership>();
		Book book = new Book("title_three","author_three");
		bookownerships.add(new BookOwnership((byte) 1, "review_one",book,1L));
		Mockito.when(query.getResultList()).thenReturn(bookownerships);
		Assert.assertEquals(MOCK_BOOKOWNERSHIP_RETURN, repo.getAllBookOwnerships());
	}
	
	@Test
	public void testGetAllUsers() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<User>();
		users.add(new User("user_one"));
		Mockito.when(query.getResultList()).thenReturn(users);
		Assert.assertEquals(MOCK_USER_RETURN, repo.getAllUsers());
	}
	
	@Test
	public void testGetAllBooksAsObjects() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("title_one", "author_one"));
		Mockito.when(query.getResultList()).thenReturn(books);
		Assert.assertEquals(books, repo.getAllBooksAsObjects());
	}
	
	@Test
	public void testGetAllBookOwnershipsAsObjects() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<BookOwnership> bookownerships = new ArrayList<BookOwnership>();
		Book book = new Book("title_three","author_three");
		bookownerships.add(new BookOwnership((byte) 1, "review_one",book,1L));
		Mockito.when(query.getResultList()).thenReturn(bookownerships);
		Assert.assertEquals(bookownerships, repo.getAllBookOwnershipsAsObjects());
	}
	
	@Test
	public void testGetAllUsersAsObjects() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<User>();
		users.add(new User("user_one"));
		Mockito.when(query.getResultList()).thenReturn(users);
		Assert.assertEquals(users, repo.getAllUsersAsObjects());
	}
	
	@Test
	public void testGetBookOwnership() {
		Book book = new Book("title_three","author_three");
		BookOwnership bookownership = new BookOwnership((byte) 1, "review_one",book,1L);
		Mockito.when(repo.retrieveBookOwnershipByID(1L)).thenReturn(bookownership);
		Assert.assertEquals(MOCK_BOOKOWNERSHIP_INPUT, repo.getBookOwnership(1L));
	}
	
	@Test
	public void testGetAllBookOwnershipsForUser() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<BookOwnership> bookownerships = new ArrayList<BookOwnership>();
		Book book = new Book("title_three","author_three");
		bookownerships.add(new BookOwnership((byte) 1, "review_one",book,1L));
		Mockito.when(query.getResultList()).thenReturn(bookownerships);
		Assert.assertEquals(MOCK_BOOKOWNERSHIP_RETURN, repo.getAllBookOwnershipsForUser(1L));
	}
	
	@Test
	public void testGetUser() {
		User user = new User("user_one");
		Mockito.when(repo.retrieveUser(1L)).thenReturn(user);
		Assert.assertEquals(MOCK_USER_INPUT, repo.getUser(1L));
	}
	
	@Test
	public void testGetUserByUsername() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<User>();
		users.add(new User("user_two"));	
		Mockito.when(query.getResultList()).thenReturn(users);
		Assert.assertEquals(MOCK_USER, repo.getUserByUsername("user_two"));
	}
	
	@Test
	public void testCreateBook() {
		String reply = repo.addBook(MOCK_BOOK_INPUT);
		Assert.assertEquals(reply, "{\"message\": \"book has been successfully added to Database\"}");
	}
	
	@Test
	public void testCreateUser() {
		String reply = repo.addUser(MOCK_USER_INPUT);
		Assert.assertEquals(reply, "{\"message\": \"user has been successfully added\"}");
	}
	
	@Test
	public void testCreateBookOwnership() {
		String reply = repo.addBookForUser(MOCK_BOOKOWNERSHIP_INPUT);
		Assert.assertEquals(reply, "{\"message\": \"book has been successfully added to your Library\"}");
	}
	

	@Test
	public void testDeleteBookForUser() {
		String reply = repo.deleteBookForUser(1L);
		Assert.assertEquals(reply, "{\"message\": \"book has been successfully removed from your Library\"}");
	}
	
	@Test
	public void testDeleteUser() {
		String reply = repo.deleteUser(1L);
		Assert.assertEquals(reply, "{\"message\": \"user successfully deleted\"}");
	}
	
	@Test
	public void testRetrieveBook() {
		Book book = new Book("title_one","author_one");
		Mockito.when(manager.find(Book.class, 1L)).thenReturn(book);
		Assert.assertEquals(book, repo.retrieveBook(1L));
	}
	
	@Test
	public void testRetrieveUser() {
		User user = new User("user_one");
		Mockito.when(manager.find(User.class, 1L)).thenReturn(user);
		Assert.assertEquals(user, repo.retrieveUser(1L));
	}
	
	@Test
	public void testRetrieveBookOwnershipByID() {
		Book book = new Book("title_three","author_three");
		BookOwnership bookownership = new BookOwnership((byte) 1, "review_one",book,1L);
		Mockito.when(manager.find(BookOwnership.class, 1L)).thenReturn(bookownership);
		Assert.assertEquals(bookownership, repo.retrieveBookOwnershipByID(1L));
	}
	
	@Test
	public void testRetrieveUserFromUsername() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<User>();
		User user = new User("user_one");
		users.add(user);	
		Mockito.when(query.getResultList()).thenReturn(users);
		Assert.assertEquals(user, repo.retrieveUserFromUsername("user_one"));
	}
	
	@Test
	public void testUpdateUser() {
		User user = new User("user_one");
		Mockito.when(manager.find(User.class, 1L)).thenReturn(user);
		String reply = repo.updateUser(MOCK_USER,1L);
		Assert.assertEquals("{\"message\": \"account has been sucessfully updated\"}", reply);
	}


}
