package com.topoinventari.movies.models;


public class Movie {

	private int id;
	private String title;
	private String author;
	private int productionYear;
	private double price;

	public Movie(int id, String title, String author, int productionYear, double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.productionYear = productionYear;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public int getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public double getPrice() {
		return price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setId(int id) {
		this.id = id;

	}

	@Override
	public String toString() {
		return "("+id+") " + title + " of " + author + ", " + productionYear + " = " + price+"€";
	}
}
