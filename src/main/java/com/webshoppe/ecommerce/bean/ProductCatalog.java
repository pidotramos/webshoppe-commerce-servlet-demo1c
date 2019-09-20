package com.webshoppe.ecommerce.bean;

import java.util.List;

import com.webshoppe.ecommerce.entity.Book;
import com.webshoppe.ecommerce.entity.Flower;
import com.webshoppe.ecommerce.entity.Toy;

public class ProductCatalog {
	private List<Toy> toys;
	private List<Book> books;
	private List<Flower> flowers;

	public List<Toy> getToys() {
		return toys;
	}

	public void setToys(List<Toy> toys) {
		this.toys = toys;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(List<Flower> flowers) {
		this.flowers = flowers;
	}

}
