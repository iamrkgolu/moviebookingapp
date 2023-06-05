//package com.moviebookingapp.model;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//@SpringBootTest
//public class MovieTest {
//
//    @Test
//    void testGetLoginId() throws Exception {
//        Movie movie=Mockito.mock(Movie.class);
//        when(movie.getMovieId()).thenReturn(1);
//        assertEquals(movie.getMovieId(), 1);
//    }
//    @Test
//    void testGetMovieName() throws Exception {
//        Movie movie=Mockito.mock(Movie.class);
//        when(movie.getMovieName()).thenReturn("Krish");
//        assertEquals(movie.getMovieName(), "Krish");
//    }
//   
//    @Test
//    void testGetReleaseDate() throws Exception {
//        Movie movie=Mockito.mock(Movie.class);
//        when(movie.getReleaseDate()).thenReturn(new Date(2021,06,12));
//        assertEquals(movie.getReleaseDate(), new Date(2021,06,12));
//    }
//
//    @Test
//    void testSetLoginId() throws Exception {
//        Movie movie=Mockito.mock(Movie.class);
//        when(movie.setMovieId(1)).thenReturn(1);
//        assertEquals(movie.setMovieId(1), 1);
//    }
//    @Test
//    void testSetMovieName() throws Exception {
//        Movie movie=Mockito.mock(Movie.class);
//        when(movie.setMovieName("Krish")).thenReturn("Krish");
//        assertEquals(movie.setMovieName("Krish"), "Krish");
//    }
//    
//    @Test
//    void testSetReleaseDate() throws Exception {
//        Movie movie=Mockito.mock(Movie.class);
//        when(movie.setReleaseDate(new Date(2021,06,12))).thenReturn(new Date(2021,06,12));
//        assertEquals(movie.setReleaseDate(new Date(2021,06,12)), new Date(2021,06,12));
//    }
//}
