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


	public RentalService(){

		rentals = new HashMap<>();
		rentals.put(1, new Rental(1,1,1,5));
		rentals.put(2, new Rental(2,2,1,3));
		rentals.put(3, new Rental(3,3,2,6));

		nextId = 4;

	}

	public Rental getById(int id) {
		return rentals.get(id);
	}

	public Collection<Rental> findByMovie(String search) {

		final Collection<Rental> result;

		if (search != null) {
			result = this.rentals.values().stream()
					.filter(rental -> rental.getMovieTitle().toLowerCase().contains(search.toLowerCase()))
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

	public void deleteRental(int id) {
		System.out.println("Deleted the rental with id " + id);
	}
}
