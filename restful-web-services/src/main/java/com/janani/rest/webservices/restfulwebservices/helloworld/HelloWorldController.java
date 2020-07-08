package com.janani.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

	// HTTP Request Method - GET
	// URI - /hello-world
	// Return - String
	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	// @GetMapping(path = "/hello-world")
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	// HTTP Request Method - GET
	// URI - /hello-world-bean
	// Return - HelloWorldBean 
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	// HTTP Request Method - GET
	// URI - /hello/{name} -> /hello/Janani
	// Return - HelloWorldBean -> Hello Janani
	@GetMapping("/hello/{name}")
	public HelloWorldBean helloPath(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello %s",name));
	}
}
