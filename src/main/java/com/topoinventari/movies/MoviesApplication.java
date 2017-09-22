package com.topoinventari.movies;


import com.topoinventari.movies.controllers.MovieApi;
import com.topoinventari.movies.controllers.RentalApi;
import com.topoinventari.movies.services.MovieService;
import com.topoinventari.movies.services.RentalService;
import com.topoinventari.movies.services.UserService;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MoviesApplication extends Application<MoviesConfiguration> {
//Alt + intro per desplegar ho de sugerencias de errores

	public static void main(String[] args) throws Exception {
		new MoviesApplication().run("server","src/main/resources/my-app.yaml");
	}

	@Override
	public String getName() {
		return "Movies";
	}

	@Override
	public void initialize(Bootstrap<MoviesConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/assets/", "/","movies.html"));
	}

	@Override
	public void run(MoviesConfiguration configuration, Environment environment) {

		/*
		 * The services that we need
		 */

		MovieService movieService = new MovieService();
		UserService userService = new UserService();
		RentalService rentalService = new RentalService(movieService,userService);

		/*
		 * Controllers
		 */

		MovieApi movieApi = new MovieApi(movieService);
		RentalApi rentalApi = new RentalApi(rentalService);

		/*
		 * Setup controllers and api to dropwizard
		 */

		environment.jersey().register(movieApi);
		environment.jersey().register(rentalApi);



	}
}
