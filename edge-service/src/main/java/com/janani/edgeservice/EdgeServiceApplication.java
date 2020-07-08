package com.janani.edgeservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.Data;

@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class EdgeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeServiceApplication.class, args);
	}
}

@Data
class Screener {
	private String name;
}

@FeignClient("screener-catalog-service")
interface ScreenerClient {

	@GetMapping("/screeners")
	Resources<Screener> readScreeners();
}

@RestController
class PanelistApiAdapterRestController {

	private final ScreenerClient screenerClient;

	public PanelistApiAdapterRestController(ScreenerClient screenerClient) {
		this.screenerClient = screenerClient;
	}

	public Collection<Screener> fallback() {
		return new ArrayList<>();
	}

	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping("/panelist")
	public Collection<Screener> list() {
		return screenerClient.readScreeners().getContent().stream().filter(this::isPanelist)
				.collect(Collectors.toList());
	}

	private boolean isPanelist(Screener screener) {
		return !screener.getName().equals("Aishu") && !screener.getName().equals("Bhuvi")
				&& !screener.getName().equals("Rashika");
	}
}