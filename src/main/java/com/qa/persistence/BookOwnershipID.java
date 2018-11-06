package com.qa.persistence;

import
java.io.Serializable;

public class BookOwnershipID implements Serializable {

	private Book book;
	private User user;

	public BookOwnershipID() {
		
	}
	
	public BookOwnershipID(Book book, User user) {
		this.book=book;
		this.user=user;
	}
	
	public Book getBook() {
		return book;
	}

	public User getUser() {
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookOwnershipID other = (BookOwnershipID) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}	

}
