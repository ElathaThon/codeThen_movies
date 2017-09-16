package com.topoinventari.movies.services;

import com.topoinventari.movies.models.Rental;

import java.util.HashMap;
import java.util.Map;

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

}
