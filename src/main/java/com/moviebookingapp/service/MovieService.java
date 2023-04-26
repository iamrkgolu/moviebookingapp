package com.moviebookingapp.service;

import java.util.List;

import com.moviebookingapp.exceptions.MovieIdAlreadyExistsExceptions;
import com.moviebookingapp.model.Movie;

public interface MovieService {

	List<Movie> getAllMovies();

	Movie addMovie(Movie movie) throws MovieIdAlreadyExistsExceptions;

	boolean deleteMovie(int movieId);

	Movie getMovieById(int movieId);

}
