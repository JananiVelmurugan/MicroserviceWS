package com.naresh.authmodule;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin
@EnableResourceServer
@EnableAuthorizationServer
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableWebSecurity(debug = true)
@RestController
public class AuthModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthModuleApplication.class, args);
	}
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		System.out.println("Called /user:" + user );
		return user;
	}
}
