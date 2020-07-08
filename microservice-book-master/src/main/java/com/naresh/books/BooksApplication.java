package com.naresh.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
@EnableFeignClients
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}
}
