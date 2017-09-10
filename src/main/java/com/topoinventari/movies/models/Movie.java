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


}
