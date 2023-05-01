package com.moviebookingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingapp.exceptions.MovieIdAlreadyExistsExceptions;
import com.moviebookingapp.model.Movie;
import com.moviebookingapp.repository.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie addMovie(Movie movie) throws MovieIdAlreadyExistsExceptions {
		Optional<Movie> findById = movieRepository.findById(movie.getMovieId());
		Movie findByMovieName = movieRepository.findByMovieName(movie.getMovieName());
		if (findById.isPresent() || findByMovieName != null) {
			throw new MovieIdAlreadyExistsExceptions();
		}
		return movieRepository.saveAndFlush(movie);
	}

	@Override
	public boolean deleteMovie(int movieId) {
		Optional<Movie> findById = movieRepository.findById(movieId);
		if (findById.isPresent()) {
//			ticketService.deleteTicketByMovie(findById.get().getMovieName());
			movieRepository.deleteById(movieId);
			return true;
		}
		return false;
	}

	@Override
	public Movie getMovieById(int movieId) {
		Optional<Movie> findById = movieRepository.findById(movieId);
		if (findById.isPresent()) {
			return movieRepository.findById(movieId).get();
		}
		return null;
	}

	@Override
	public Movie getMovieByMovieName(String movieName) {
		return movieRepository.findByMovieName(movieName);
	}

	@Override
	public Movie updateMovie(String movieName, Movie movie) {
		Movie findByMovieName = movieRepository.findByMovieName(movieName);
		if (findByMovieName != null) {
			Movie movie2 = new Movie();
			movie2.setMovieName(movieName);
			movie2.setMovieId(movie.getMovieId());
			return movieRepository.saveAndFlush(movie2);
		}
		return null;
	}

	@Override
	public List<String> getMoviesList() {
		List<String> listMovies = movieRepository.moviesName();
		if(listMovies.isEmpty()){
			return null;
		}else{
			return listMovies;
		}
	}

}
