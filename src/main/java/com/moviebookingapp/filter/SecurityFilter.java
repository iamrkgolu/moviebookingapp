//package com.moviebookingapp.filter;
//
//import java.io.IOException;
//
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class SecurityFilter implements Filter {
//
//	@Override
//	@Order(Ordered.HIGHEST_PRECEDENCE)
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest httpReq = (HttpServletRequest) request;
//		HttpServletResponse httpRes = (HttpServletResponse) response;
//		httpRes.setHeader("Access-Control-Allow-Origin", "*");
//		httpRes.setHeader("Access-Control-Allow-Credentials", "true");
//		httpRes.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//		httpRes.setHeader("Access-Control-Max-Age", "3600");
//		httpRes.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Authorization, remember-me");
//		chain.doFilter(request, response);
//		
//	}
//
//}
