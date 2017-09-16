package com.topoinventari.movies.controllers;

import com.topoinventari.movies.models.Rental;
import com.topoinventari.movies.services.RentalService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Api for {@link Rental}
 */

@Path("/rentals")
@Produces(MediaType.APPLICATION_JSON)
public class RentalApi {

	private RentalService rentalService = new RentalService();

	public RentalApi(RentalService rentalService) {
		this.rentalService = rentalService;
	}

	@GET
	public Collection<Rental> viewRentalsMovie(@QueryParam("searchMovie") String searchMovie){
		return rentalService.findByMovie(searchMovie);
	}

	@GET
	public Collection<Rental> viewRentalsUser(@QueryParam("searchUser") String searchUser) {
		return rentalService.findByUser(searchUser);
	}

	@GET
	@Path("{id}")
	public Rental viewRental(@PathParam("id") int id) {
		return rentalService.getById(id);
	}

	@POST
	public Rental addRental(Rental rental) {
		return rentalService.addRental(rental);
	}

	@PUT
	@Path("{id}")
	public Rental update(@PathParam("id") int id, Rental rental) {
		return rentalService.updateRental(id, rental);
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") int id) {
		rentalService.deleteRental(id);
	}



}
