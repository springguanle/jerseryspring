package com.wake.jerseryspring.service;

import java.util.List;

import com.wake.jerseryspring.beans.Book;

public interface BookService {

	int addBook(Book book);
	
	int modfiyBook(Book book);
	
	int removeBook(Integer id);
	
	Book queryBookById(Integer id);
	
	List<Book> queryBooks(int offset, int limit);
}
