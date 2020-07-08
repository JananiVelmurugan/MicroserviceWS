package com.janani.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDAOService service;

	// retrieve all users
	// HTTP Request Method - GET
	// URI - /users
	// Return - List of Users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// retrieve a user
	// HTTP Request Method - GET
	// URI - /user/{id} -> /users/1
	// Return - User
	@GetMapping("/user/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		return user;
	}

	// create a new user
	// HTTP Request Method - POST
	// URI - /users
	// Return - Status Code
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
