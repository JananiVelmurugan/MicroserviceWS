package com.naresh.apigateway.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsFilter implements Filter {

	public SimpleCorsFilter() {
	}

	@Override
	public void doFilter(ServletRequest req1, ServletResponse res1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) res1;
		HttpServletRequest req = (HttpServletRequest) req1;

		 String REQUEST_ORIGIN_NAME = "Origin";
		 String origin = req.getHeader(REQUEST_ORIGIN_NAME);
		
		 System.out.println("APIGateway-> Request from " + origin + "( " + req.getMethod() +")" + req.getRequestURI() );
		if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
			res.setHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE, PATCH");
			res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
			res.setHeader("Access-Control-Max-Age", "3600");
			System.out.println("APIGateway Skip next request");
		} else {
			System.out.println("APIGateway Forwarding to next request");
			res.setHeader("Access-Control-Allow-Origin", "*");
			chain.doFilter(req, res);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void destroy() {
	}
}
