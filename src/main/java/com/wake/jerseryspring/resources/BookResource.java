package com.wake.jerseryspring.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wake.jerseryspring.beans.Book;
import com.wake.jerseryspring.service.BookService;

/**
 * 使用Component创建资源类对象
 */
@Component
@Path("lib")
public class BookResource {

	/**
	 * 引用类型，使用spring的di注入值
	 */
	//byType
	@Autowired
	private BookService bookService;
	
	//添加book
	@Path("book")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Book addBook(@FormParam("isbn") String isbn,
			@FormParam("name") String name, 
			@FormParam("price") float price){
		System.out.println("addBook");
		Book book = new Book(isbn,name,price);
		int rows = bookService.addBook(book);
		if(rows <= 0 ){
			//添加图书是失败的
			book.setId( 0 );
		}
		
		return book;
		
	}
	
	@Path("book/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBook(@PathParam("id") Integer bookId){
		
		Book book = bookService.queryBookById(bookId);
		return book;
	}
	
	
	@Path("book/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Book modifyBook(@PathParam("id") Integer id,
			@FormParam("isbn") String isbn,
			@FormParam("name") String name,
			@FormParam("price") float price){
		Book book = new Book(isbn, name, price);
		book.setId(id);
		
		int rows  = bookService.modfiyBook(book);
		if(rows > 0 ){
			book = bookService.queryBookById(id);
		} else {
			book.setId(0);
		}
		return book;
		
	}
	
	@Path("book/{id}")
	@DELETE
	public Response removeBook(@PathParam("id") Integer id){
		int rows = bookService.removeBook(id);
		if(rows > 0 ){
			return Response.status(204).build();
		} else {
			return Response.status(500).build();
		}
	}
	

	
	@Path("books")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> queryBooks(@QueryParam("offset") Integer offset,
			@QueryParam("limit") Integer limit){
		
		List<Book> books = bookService.queryBooks(offset, limit);
		return books;
	}
	
	
}
