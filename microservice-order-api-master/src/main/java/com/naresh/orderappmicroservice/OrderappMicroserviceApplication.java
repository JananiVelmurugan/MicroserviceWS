package com.naresh.orderappmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@EnableWebSecurity(debug = true)
@SpringBootApplication
@EnableFeignClients
//@EnableOAuth2Sso
public class OrderappMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderappMicroserviceApplication.class, args);
	}
}
