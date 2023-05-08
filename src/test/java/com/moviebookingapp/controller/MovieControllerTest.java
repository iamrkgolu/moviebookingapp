package com.moviebookingapp.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.moviebookingapp.model.Movie;
import com.moviebookingapp.service.MovieService;

public class MovieControllerTest {
	
	@Mock
	private MovieService movieService;
	
	@InjectMocks
	private MovieController movieController;
	
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
	}

	List<Movie> movieList = new ArrayList<Movie>();
	
	@Test
	public void getAllMovieSuccess() throws Exception {
		Movie movie=new Movie();
		movie.setMovieId(1234);
		 movie.setMovieName("TestMovie");
		 movie.setReleaseDate(new Date(2023,06,06));
		 movie.setActors(List.of("Ritik","Priyanka"));
		 movie.setDescription("Test Movie No Description");
		 movie.setGenre("Test");
		 movie.setLanguage("Hindi");
		 movie.setTicket(null);

		 movieList.add(movie);
		when(movieService.getAllMovies()).thenReturn(movieList);

		List<Movie> uList = movieService.getAllMovies();
		assertEquals(movieList, uList);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/moviebooking/all")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());

	}
	

}
