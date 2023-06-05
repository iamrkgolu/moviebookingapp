package com.moviebookingapp.controller;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.moviebookingapp.dto.User;
import com.moviebookingapp.dto.UserDto;

@RestController
@RequestMapping("/auth/v1.0")
@CrossOrigin(origins = "*")
public class LoginController {
	
	@PostMapping("/login")
	public ResponseEntity<?> consumeLogin(@RequestBody UserDto userdto) throws RestClientException, Exception {
		String baseUrl = "http://35.81.104.202:8082/auth/v1/login";// API consumption.. actual api is hidden -not exposed

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Map<String, String>> result;

		try {
			result = restTemplate.exchange(baseUrl, HttpMethod.POST, getHeaders(userdto),
					new ParameterizedTypeReference<Map<String, String>>() {
					});
		} catch (Exception e) {
			return new ResponseEntity<String>("Login failed", HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<Map<String, String>>(result.getBody(), HttpStatus.CREATED);
	}

	private static HttpEntity<UserDto> getHeaders(UserDto userdto) {
		HttpHeaders headers = new HttpHeaders();

		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Access-Control-Allow-Origin", "*");
		return new HttpEntity<UserDto>(userdto, headers);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<?> registerUser(@RequestBody User user) throws RestClientException, Exception {
		String baseUrl = "http://35.81.104.202:8082/auth/v1/addUser";// API consumption.. actual api is hidden -not exposed
		HttpEntity<User> httpEntity = new HttpEntity<User>(user, null);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange(baseUrl, HttpMethod.POST,httpEntity,User.class) ;
	}
	
	@PutMapping("/forgetPassword/{userId}")
	public ResponseEntity<?> passwordReset(@PathVariable("userId") String userId, @RequestBody User user)
	{
		String baseUrl = "http://35.81.104.202:8082/auth/v1/forgetPassword/{userId}";
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> httpEntity = new HttpEntity<>(user,null);
       
		
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange(baseUrl, HttpMethod.PUT,httpEntity,String.class,userId) ;
	}
}
