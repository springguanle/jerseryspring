package com.wake.jerseryspring.beans;

public class Book {

	private Integer id;
	private String isbn;
	private String name;
	private float price;
	
	public Book(String isbn, String name, float price) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.price = price;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "图书 [id=" + id + ", isbn=" + isbn + ", name=" + name + ", price=" + price + "]";
	}
	
}
