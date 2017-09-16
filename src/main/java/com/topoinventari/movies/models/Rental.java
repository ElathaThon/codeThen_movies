package com.topoinventari.movies.models;

import com.topoinventari.movies.services.MovieService;
import com.topoinventari.movies.services.UserService;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * The rentals of the movies with the client that have it
 */
public class Rental {

	private int id;
	private int idMovie;
	private int idUser;
	private int days; //Days that the user is going to have the movie, we say it in advance

	private User user;
	private Movie movie;

	public Rental(){
		// I need this for the POST method in dropwizard
	}

	public Rental(int id, int idMovie, int idUser, int days) {

		this.id = id;
		this.idMovie = idMovie;
		this.idUser = idUser;
		this.days = days;

		UserService userService = new UserService();
		this.user = userService.getById(idUser);

		MovieService movieService = new MovieService();
		this.movie = movieService.getById(idMovie);

		if (!this.movie.isAvailable()) {
			throw new WebApplicationException("Pelicula no encontrada", Response.Status.NOT_FOUND);
		}

	}

	public int getId() {
		return id;
	}

	public int getIdMovie() {
		return idMovie;
	}

	public User getUser() {
		return user;
	}

	public Movie getMovie() {
		return movie;
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
		return user.getName();
		//return userService.getById(idUser).getName();
	}

}
