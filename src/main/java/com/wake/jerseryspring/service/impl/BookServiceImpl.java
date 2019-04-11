package com.wake.jerseryspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wake.jerseryspring.beans.Book;
import com.wake.jerseryspring.dao.BookDao;
import com.wake.jerseryspring.service.BookService;

//使用Service注解创建业务层对象
@Service
public class BookServiceImpl implements BookService {

	/**
	 * 引用类型，使用spring的依赖注入
	 */
	//byType
	@Autowired
	private BookDao bookDao;
	
	@Override
	public int addBook(Book book) {
		int rows  = bookDao.insertBook(book);
		return rows;
	}

	@Override
	public int modfiyBook(Book book) {
		int rows = bookDao.updateBook(book);
		return rows;
	}

	@Override
	public int removeBook(Integer id) {
		int rows = bookDao.deleteBook(id);
		return rows;
	}

	@Override
	public Book queryBookById(Integer id) {
		Book book = bookDao.selectBookById(id);
		return book;
	}

	@Override
	public List<Book> queryBooks(int offset, int limit) {
		List<Book> books = bookDao.selectBooks(offset, limit);
		return books;
	}

}
