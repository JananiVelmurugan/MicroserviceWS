package com.naresh.orderappmicroservice.external;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naresh.orderappmicroservice.dto.UserDTO;

@FeignClient(url="http://localhost:9001/auth-service" , name="auth-service")
public interface UserServiceClient {

	 @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET, produces = "application/json")
	 UserDTO getUser(@PathVariable("userId") Long userId );
	 
	 
	 @RequestMapping(value = "/currentuser", method = RequestMethod.GET, produces = "application/json")
	 UserDTO getCurrentUser(@RequestHeader("Authorization") String authorizationToken );
}

