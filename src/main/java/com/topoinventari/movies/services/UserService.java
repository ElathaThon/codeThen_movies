package com.topoinventari.movies.services;


import com.topoinventari.movies.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

	private Map<Integer, User> users;

	private int nextId;

	public UserService() {

		users = new HashMap<>();
		users.put(1, new User(1,"Pepe"));
		users.put(2, new User(2,"Mary"));
		users.put(3, new User(3,"Jhon"));
		users.put(4, new User(4,"Felipe"));
		users.put(5, new User(5,"Pedro"));
		users.put(6, new User(6,"Anna"));

		nextId = 7;

	}

	public User getById(int id) {
		return users.get(id);
	}



}
