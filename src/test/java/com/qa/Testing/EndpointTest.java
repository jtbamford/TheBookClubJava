package com.qa.Testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.rest.Endpoint;
import com.qa.service.BookService;

@RunWith(MockitoJUnitRunner.class)
public class EndpointTest {
	
	private static final String MOCK_BOOKS = "books";
	
	private static final String MOCK_BOOKOWNERSHIPS = "bookownerships";
	
	private static final String MOCK_USERS = "users";

	private static final String MOCK_BOOK = "book";
	
	private static final String MOCK_MESSAGE = "message";
	
	private static final String MOCK_USER = "user";
	
	private static final String MOCK_USERNAME = "username";
	
	private static final String MOCK_BOOKFORUSER = "book for user";
	
	@InjectMocks
	private Endpoint endpoint;

	@Mock
	private BookService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void testGetAllBooks() {
		Mockito.when(service.getAllBooks()).thenReturn(MOCK_BOOKS);
		Assert.assertEquals(MOCK_BOOKS, endpoint.getAllBooks());
	}
	
	@Test
	public void testGetAllBookOwnerships() {
		Mockito.when(service.getAllBookOwnerships()).thenReturn(MOCK_BOOKOWNERSHIPS);
		Assert.assertEquals(MOCK_BOOKOWNERSHIPS, endpoint.getAllBookOwnerships());
	}
	
	@Test
	public void testGetAllBookOwnershipsForUser() {
		Mockito.when(service.getAllBookOwnershipsForUser(1L)).thenReturn(MOCK_BOOKOWNERSHIPS);
		Assert.assertEquals(MOCK_BOOKOWNERSHIPS, endpoint.getAllBookOwnershipsForUser(1L));
	}

	@Test
	public void testGetAllUsers() {
		Mockito.when(service.getAllUsers()).thenReturn(MOCK_USERS);
		Assert.assertEquals(MOCK_USERS, endpoint.getAllUsers());
	}
	
	@Test
	public void testGetUserByUsername() {
		Mockito.when(service.getUserByUsername(MOCK_USERNAME)).thenReturn(MOCK_USER);
		Assert.assertEquals(MOCK_USER, endpoint.getUser(MOCK_USERNAME));
	}
	
	@Test
	public void testGetUserByID() {
		Mockito.when(service.getUser(1L)).thenReturn(MOCK_USER);
		Assert.assertEquals(MOCK_USER, endpoint.getUser(1L));
	}
	
	@Test
	public void testGetBookOwnershipByID() {
		Mockito.when(service.getBookOwnership(1L)).thenReturn(MOCK_BOOKFORUSER);
		Assert.assertEquals(MOCK_BOOKFORUSER, endpoint.getBookOwnership(1L));
	}
	
	
	@Test
	public void testCreateBook() {
		Mockito.when(service.addBook(MOCK_BOOK)).thenReturn(MOCK_MESSAGE);
		Assert.assertEquals(MOCK_MESSAGE, endpoint.addBook(MOCK_BOOK));
		Mockito.verify(service).addBook(MOCK_BOOK);
	}
	
	@Test
	public void testCreateUser() {
		Mockito.when(service.addUser(MOCK_USER)).thenReturn(MOCK_MESSAGE);
		Assert.assertEquals(MOCK_MESSAGE, endpoint.addUser(MOCK_USER));
		Mockito.verify(service).addUser(MOCK_USER);
	}
	
	@Test
	public void testCreateBookForUser() {
		Mockito.when(service.addBookForUser(MOCK_BOOKFORUSER)).thenReturn(MOCK_MESSAGE);
		Assert.assertEquals(MOCK_MESSAGE, endpoint.addBookForUser(MOCK_BOOKFORUSER));
		Mockito.verify(service).addBookForUser(MOCK_BOOKFORUSER);
	}

	@Test
	public void testDeleteBookForUser() {
		Mockito.when(service.deleteBookForUser(1L)).thenReturn(MOCK_MESSAGE);
		Assert.assertEquals(MOCK_MESSAGE, endpoint.deleteBookForUser(1L));
		Mockito.verify(service).deleteBookForUser(1L);
	}
	
	@Test
	public void testDeleteUser() {
		Mockito.when(service.deleteUser(1L)).thenReturn(MOCK_MESSAGE);
		Assert.assertEquals(MOCK_MESSAGE, endpoint.deleteUser(1L));
		Mockito.verify(service).deleteUser(1L);
	}
	
	@Test
	public void testUpdateUser() {
		Mockito.when(service.updateUser(MOCK_USER,1L)).thenReturn(MOCK_MESSAGE);
		Assert.assertEquals(MOCK_MESSAGE, endpoint.updateUser(MOCK_USER,1L));
		Mockito.verify(service).updateUser(MOCK_USER,1L);
	}

}
