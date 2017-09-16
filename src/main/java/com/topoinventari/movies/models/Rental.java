package com.topoinventari.movies.models;

import com.topoinventari.movies.services.MovieService;
import com.topoinventari.movies.services.UserService;

/**
 * The rentals of the movies with the client that have it
 */
public class Rental {

	private int id;
	private int idMovie;
	private int idUser;
	private int days; //Days that the user is going to have the movie, we say it in advance

	private MovieService movieService = new MovieService();
	private UserService userService = new UserService();

	public Rental(){
		// I need this for the POST method in dropwizard
	}

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

	public String getUserName() {
		return userService.getById(idUser).getName();
	}

}
