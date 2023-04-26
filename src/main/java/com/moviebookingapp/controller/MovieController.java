package com.moviebookingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebookingapp.exceptions.MovieIdAlreadyExistsExceptions;
import com.moviebookingapp.model.Movie;
import com.moviebookingapp.service.MovieService;

@RestController
@RequestMapping(value = "/api/v1.0/moviebooking")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping(value = "/all")
	public ResponseEntity<?> getAllMovies() {
		List<Movie> movieList = movieService.getAllMovies();
		if (movieList != null) {
			return new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Movies List Empty!!", HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/movies/search/{movieId}")
	public ResponseEntity<?> getMovieById(@PathVariable("movieId") int movieId){
		Movie movie = movieService.getMovieById(movieId);
		if (movie != null) {
			return new ResponseEntity<Movie>(movie, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Movies List Empty!!", HttpStatus.NO_CONTENT);
	}

	@PostMapping(value = "/admin/addmovie")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie) throws MovieIdAlreadyExistsExceptions {
		if (movieService.addMovie(movie) != null) {
			return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
		}

		return new ResponseEntity<String>("Movie object is null", HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value = "/admin/delete/{movieId}")
	public ResponseEntity<?> deleteMovie(@PathVariable ("movieId") int movieId)
	{
		if(movieService.deleteMovie(movieId))
		{
			return new ResponseEntity<String>("Movie got deleted successfully",HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Movie did not get deleted ",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/*
	 * 
	 */

}
