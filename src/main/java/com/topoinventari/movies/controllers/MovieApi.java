package com.topoinventari.movies.controllers;

import com.topoinventari.movies.models.Movie;
import com.topoinventari.movies.services.MovieService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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

}
