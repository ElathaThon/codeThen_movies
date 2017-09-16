package com.topoinventari.movies.services;

import com.topoinventari.movies.models.Movie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service to manage {@link Movie}
 * */
public class MovieService {

	private Map<Integer, Movie> movies;

	private int nextId;

	public MovieService() {
		movies = new HashMap<>();
		movies.put(1, new Movie(1,"movie1","author1",2011,11.11));
		movies.put(2, new Movie(2,"movie2","author2",2012,22.22));
		movies.put(3, new Movie(3,"movie3","author3",2013,33.33));

		nextId = 4;

	}

	public Movie getById(int id) {
		return movies.get(id);
	}

	public Collection<Movie> findByTitle(String search) {

		final Collection<Movie> result;

		if (search != null) {
			result = this.movies.values().stream()
					.filter(movie -> movie.getTitle().toLowerCase().contains(search.toLowerCase()))
					.collect(Collectors.toList());
		} else {
			result = this.movies.values();
		}

		return result;

	}

	public Movie addMovie(Movie movie) {

		movie.setId(nextId);
		movies.put(nextId, movie);

		nextId++;

		System.out.println(movie);
		return movie;
	}

	public Movie updateMovie(int id, Movie movie) {

		Movie editMovie = getById(id);

		editMovie.setTitle(movie.getTitle());
		editMovie.setAuthor(movie.getAuthor());
		editMovie.setProductionYear(movie.getProductionYear());
		editMovie.setPrice(movie.getPrice());

		return editMovie;

	}

	public void deleteMovie(int id) {
		movies.remove(id);
	}
}
