package com.topoinventari.movies.models;

/**
 * The rentals of the movies with the client that have it
 */
public class Rental {

	private int id;
	private int idMovie;
	private int idUser;
	private int days;

	public Rental(int id, int idMovie, int idUser, int days) {
		this.id = id;
		this.idMovie = idMovie;
		this.idUser = idUser;
		this.days = days;
	}

	public int getId() {
		return id;
	}

	public int getIdMovie() {
		return idMovie;
	}

	public int getIdUser() {
		return idUser;
	}

	public int getDays() {
		return days;
	}
}
