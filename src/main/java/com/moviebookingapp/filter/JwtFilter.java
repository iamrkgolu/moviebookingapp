package com.moviebookingapp.filter;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;

		httpRes.setHeader("Access-Control-Allow-Origin", "*");
		httpRes.setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		httpRes.setHeader("Accept", MediaType.APPLICATION_JSON_VALUE);
		httpRes.setHeader("Access-Control-Allow-Credentials", "true");
		httpRes.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		httpRes.setHeader("Access-Control-Max-Age", "3600");
		httpRes.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Authorization, remember-me");
		
		String authHeader = httpReq.getHeader("authorization");
		
		if(authHeader ==null || !authHeader.startsWith("Bearer"))
		{
			throw new ServletException("Missing or invalid authentication header");
		}
		
		String jwtToken = authHeader.substring(7);
		Claims claims = Jwts.parser().setSigningKey("secret key").parseClaimsJws(jwtToken).getBody();
		
		httpReq.setAttribute("loginId", claims);
		chain.doFilter(request, response);
		
	}

}
