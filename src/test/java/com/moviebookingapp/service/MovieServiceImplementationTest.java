package com.moviebookingapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.moviebookingapp.model.Movie;
import com.moviebookingapp.repository.MovieRepository;

@ExtendWith(MockitoExtension.class)
public class MovieServiceImplementationTest {
	 @Mock
	 private MovieRepository movieRepository;
	 
	 @InjectMocks
	 private MovieServiceImplementation movieServiceImplementation;
	 
	 @Autowired
	 private MockMvc mockMvc;
	 
	 List<Movie> movieList=new ArrayList<>();
	 
	 Movie movie=new Movie();
	 
	 @BeforeEach
	 public void setUp() {
		 movie.setMovieId(1234);
		 movie.setMovieName("TestMovie");
		 movie.setReleaseDate(new Date(2023,06,06));
		 movie.setActors(List.of("Ritik","Priyanka"));
		 movie.setDescription("Test Movie No Description");
		 movie.setGenre("Test");
		 movie.setLanguage("Hindi");
		 movie.setTicket(null);
	 }
	 
	 @Test
	 public void getAllMovie() throws Exception{
		 movieList.add(movie);
		 BDDMockito.given(movieRepository.findAll()).willReturn(movieList);
		 List<Movie> mList=movieServiceImplementation.getAllMovies();
		 assertEquals(movieList, mList);
	 }
	 
//	 @Test
//	 public void addMovie() throws Exception{
//		 movieList.add(movie);
//		 BDDMockito.given(movieRepository.saveAndFlush(movie)).willReturn(movie);
//		 Movie movie1=movieServiceImplementation.addMovie(movie);
//		 assertThat(movie1).isNotNull();
//	 }
	 
//	 @Test
//	 public void updateMovie() throws Exception{
//		  
//		  BDDMockito.when(movieRepository.findByMovieName("TestMovie")).thenReturn(movie);
//		  BDDMockito.when(movieRepository.saveAndFlush(movie)).thenReturn(movie);
//		  Movie movie1=movieServiceImplementation.updateMovie("TestMovie",movie);
//		 assertThat(movie1.getGenre()).isEqualTo("Horror");
//	 }
	 
	 
	 
	 
	 @Test
	 public void deleteMovie() throws Exception{
		 Movie movie1=new Movie();
		 movie1.setMovieId(1234);
		 movie1.setMovieName("TestMovie");
		 movie1.setReleaseDate(new Date(2023,06,06));
		 movie1.setActors(List.of("Ritik","Priyanka"));
		 movie1.setDescription("Test Movie No Description");
		 movie1.setGenre("Test");
		 movie1.setLanguage("Hindi");
		 movie1.setTicket(null); 
		 when(movieRepository.findById(movie1.getMovieId())).thenReturn(Optional.of(movie1));
		 willDoNothing().given(movieRepository).deleteById(movie1.getMovieId());
		 movieServiceImplementation.deleteMovie(movie1.getMovieId());
		 verify(movieRepository,times(1)).deleteById(1234);
	 }
	 
	

}
