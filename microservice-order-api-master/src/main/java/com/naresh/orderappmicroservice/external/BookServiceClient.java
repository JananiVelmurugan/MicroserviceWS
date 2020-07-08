package com.naresh.orderappmicroservice.external;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naresh.orderappmicroservice.dto.Book;

@FeignClient(url="http://localhost:9002/book-service" , name="book-service")
public interface BookServiceClient {

	 @RequestMapping(value = "/books/{bookId}", method = RequestMethod.GET, produces = "application/json")
	 Book getBook(@RequestHeader("Authorization") String authorizationToken, @PathVariable("bookId") Long bookId );
	 
	 
	 @RequestMapping(value = "/books/{bookId}", method = RequestMethod.GET, produces = "application/json")
	 Book getBook( @PathVariable("bookId") Long bookId );
}

