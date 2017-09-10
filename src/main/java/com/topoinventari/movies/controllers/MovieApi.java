package com.topoinventari.movies.controllers;

import com.topoinventari.movies.models.Movie;
import com.topoinventari.movies.services.MovieService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Api for {@link Movie}
 * */

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieApi {

	private MovieService movieService = new MovieService();

	public MovieApi(MovieService movieService) {
		this.movieService = movieService;
	}

	@GET
	public Collection<Movie> viewMovies(@QueryParam("search") String search) {
		return movieService.findByTitle(search);
	}

	@GET
	@Path("{id}")
	public Movie viewMovie(@PathParam("id") int id) {
		return movieService.getById(id);
	}

	@POST
	public Movie addMovie(Movie movie) {
		System.out.println("Reicived movie: " + movie);
		return movieService.addMovie(movie);
	}

	@PUT
	@Path("{id}")
	public Movie update(@PathParam("id") int id, Movie movie) {
		return movieService.updateMovie(id, movie);
	}


}
