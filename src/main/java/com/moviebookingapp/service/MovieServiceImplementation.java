package com.moviebookingapp.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.moviebookingapp.exceptions.MovieIdAlreadyExistsExceptions;
import com.moviebookingapp.model.Movie;
import com.moviebookingapp.repository.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private KafkaTemplate<String,Movie> kafkaTemplate;

	private Movie saveAndFlush;
	
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
		/*
		 * Need to fix issue because when kafka server is running it is working fine
		 * But server is not running it throw error while adding movie
		 */
//		else {
//			
//			if(kafkaTemplate.getDefaultTopic()!=null) {
//				System.out.println(kafkaTemplate.getDefaultTopic());
//				saveAndFlush = movieRepository.saveAndFlush(movie);
//			    kafkaTemplate.send("movie-app","Released Movie",movie);
//				System.out.println("Kafka server working....");
//				return saveAndFlush;
//				
//			}else {
//				System.out.println("Kafka server not working....");
//				return movieRepository.saveAndFlush(movie);
//			}
//			
//		}
		kafkaTemplate.send("movie-app","Released Movie",movie);
		return movieRepository.saveAndFlush(movie);
	}

	@Override
	public boolean deleteMovie(int movieId) {
		Movie findById = movieRepository.findById(movieId).get();
		if (findById.getMovieId()!=-1) {
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
			movie2.setMovieId(findByMovieName.getMovieId());
			movie2.setActors(movie.getActors());
			movie2.setGenre(movie.getGenre());
			movie2.setDescription(movie.getDescription());
			movie2.setLanguage(movie.getLanguage());
			movie2.setReleaseDate(findByMovieName.getReleaseDate());

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
