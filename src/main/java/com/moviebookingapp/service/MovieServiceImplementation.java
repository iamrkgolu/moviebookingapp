package com.moviebookingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingapp.exceptions.MovieIdAlreadyExistsExceptions;
import com.moviebookingapp.model.Movie;
import com.moviebookingapp.repository.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie addMovie(Movie movie) throws MovieIdAlreadyExistsExceptions{
		Optional<Movie> findById = movieRepository.findById(movie.getMovieId());
		if(findById.isPresent()) {
			throw new MovieIdAlreadyExistsExceptions();
		}
		return movieRepository.saveAndFlush(movie);
	}

	@Override
	public boolean deleteMovie(int movieId) {
		Optional<Movie> findById = movieRepository.findById(movieId);
		if(findById.isPresent()) {
			movieRepository.deleteById(movieId);
			return true;
		}
		return false;
	}

	@Override
	public Movie getMovieById(int movieId){
		Optional<Movie> findById = movieRepository.findById(movieId);
		if(findById.isPresent()) {
			return movieRepository.findById(movieId).get();
		}
		return null;
	}
	

}
