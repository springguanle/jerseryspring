package com.wake.jerseryspring.dao;

import java.util.List;

import com.wake.jerseryspring.beans.Book;

public interface BookDao {

	int insertBook(Book book);
	int updateBook(Book book);
	Book selectBookById(Integer id);
	List<Book> selectBooks(int offset,int limit);
	int deleteBook(Integer id);
}
