package com.janani.oauth2inmem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.janani.oauth2inmem.config.CustomUserDetails;
import com.janani.oauth2inmem.entity.Role;
import com.janani.oauth2inmem.entity.User;
import com.janani.oauth2inmem.repository.UserRepository;

@SpringBootApplication
public class Oauth2InmemApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2InmemApplication.class, args);
	}

	/**
	 * Password grants are switched on by injecting an AuthenticationManager. Here,
	 * we setup the builder so that the userDetailsService is the one we coded.
	 * 
	 * @param builder
	 * @param repository
	 * @throws Exception
	 */
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository)
			throws Exception {
		// Setup a default user if db is empty
		if (repository.count() == 0)
			repository.save(new User("user", "user", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		builder.userDetailsService(username -> new CustomUserDetails(repository.findByUsername(username)));
	}

}
