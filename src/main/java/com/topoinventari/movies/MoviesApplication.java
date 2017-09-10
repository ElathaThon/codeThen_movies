package com.topoinventari.movies;


import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MoviesApplication extends Application<MoviesConfiguration> {
//Alt + intro per desplegar ho de sugerencias de errores

	public static void main(String[] args) throws Exception {
		new MoviesApplication().run(args);
	}

	@Override
	public String getName() {
		return "Movies";
	}

	@Override
	public void initialize(Bootstrap<MoviesConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
	}

	@Override
	public void run(MoviesConfiguration configuration, Environment environment) {

		/**
		 * The services that we need
		 * */
		/*
		Example:
		TransactionService transactionService = new TransactionService();
		UserService userService = new UserService();
		*/


		/**
		 * Controllers
		 * */


		/**
		 * APIs
		 * */
		/*
		Example:
		//TransactionApi transactionApi = new TransactionApi(transactionService);
		//UsersApi usersApi = new UsersApi(userService);
		*/


		/**
		 * Setup controllers and api to dropwizard
		 * */
		/*
		Example:
		environment.jersey().register(transactionApi);
		environment.jersey().register(usersApi);
		*/

		//Controllers

		//API


	}
}
