package com.topoinventari.movies.services;

import com.topoinventari.movies.models.Rental;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service to manage {@link Rental}
 */
public class RentalService {

	private Map<Integer, Rental> rentals;

	private int nextId;

	private MovieService movieService;
	private UserService userService;

	public RentalService(MovieService movieService, UserService userService){

		this.movieService = movieService;
		this.userService = userService;

		rentals = new HashMap<>();
		rentals.put(1, new Rental(1,1,1,5));
		rentals.put(2, new Rental(2,2,1,3));
		rentals.put(3, new Rental(3,3,2,6));

		nextId = 4;

	}

	public Rental getById(int id) {
		return rentals.get(id);
	}


	/**
	 Aquesta es la que tenia abans en el {@link Rental}, de forma que el findByMovie funcionava com el findByUser.
		 public String getMovieTitle() {
		 	return movieService.getById(idMovie).getTitle();
		 }

	 Pero crec que no haura de tenir els services en el Rental, sino en el RentalService

	 */
	public Collection<Rental> findByMovie(String search) {

		final Collection<Rental> result;

		if (search != null) {
			result = this.rentals.values().stream()
					//TODO: Not sure to if is a good way to perform the search by the movie title
					.filter(rental -> movieService.findByTitle(search).contains(search.toLowerCase()))
					.collect(Collectors.toList());
		} else {
			result = this.rentals.values();
		}

		return result;

	}

	public Collection<Rental> findByUser(String search) {

		final Collection<Rental> result;

		if (search != null) {
			result = this.rentals.values().stream()
					.filter(rental -> rental.getUserName().toLowerCase().contains(search.toLowerCase()))
					.collect(Collectors.toList());

		} else {
			result = this.rentals.values();
		}

		return result;

	}

	public Rental addRental(Rental rental) {

		rental.setId(nextId);
		rentals.put(nextId, rental);

		nextId++;
		System.out.println(rental);
		return rental;

	}

	public Rental updateRental(int id, Rental rental) {

		Rental editRental = getById(id);

		editRental.setIdUser(rental.getIdUser());
		editRental.setIdMovie(rental.getIdMovie());
		editRental.setDays(rental.getDays());

		return editRental;

	}

	/**
	 * Delete the rental and set the movie to available again
	 * */
	public void deleteRental(int id) {

		movieService.rentMovie(rentals.get(id).getIdMovie());

		System.out.println("Deleted the rental with id " + id);
		rentals.remove(id);
	}
}
