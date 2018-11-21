package com.qa.Testing;

import java.util.ArrayList;
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

	private static final String MOCK_BOOK_INPUT = "{\"title\":\"title_two\",\"author\":\"author_two\"}";
	
	private static final String MOCK_USER_INPUT = "{\"username\":\"user_one\"}";
	
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

}
