package com.topoinventari.movies.models;

import com.topoinventari.movies.services.MovieService;

/**
 * The rentals of the movies with the client that have it
 */
public class Rental {

	private int id;
	private int idMovie;
	private int idUser;
	private int days;

	private MovieService movieService = new MovieService();
	//TODO: private UserService userService = new UserService();


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

	public String getMovieTitle() {
		return movieService.getById(idMovie).getTitle();
	}

	public String getUserName() {
		//TODO: return UserService.getById(idUser).getName();
		return "abc";
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setDays(int days) {
		this.days = days;
	}
}
