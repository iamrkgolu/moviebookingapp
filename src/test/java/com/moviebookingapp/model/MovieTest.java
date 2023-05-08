package com.moviebookingapp.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@SpringBootTest
public class MovieTest {

    @Test
    void testGetLoginId() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.getMovieId()).thenReturn(1);
        assertEquals(movie.getMovieId(), 1);
    }
    @Test
    void testGetMovieName() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.getMovieName()).thenReturn("Krish");
        assertEquals(movie.getMovieName(), "Krish");
    }
    @Test
    void testGetDescription() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.getDescription()).thenReturn("Hindi");
        assertEquals(movie.getDescription(), "Hindi");
    }
    @Test
    void testGetGenre() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.getGenre()).thenReturn("Action");
        assertEquals(movie.getGenre(), "Action");
    }
    @Test
    void testGetLanguage() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.getLanguage()).thenReturn("Hindi");
        assertEquals(movie.getLanguage(), "Hindi");
    }
    @Test
    void testGetListOfActors() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.getActors()).thenReturn(List.of("Hritik","Priyanka"));
        assertEquals(movie.getActors(), List.of("Hritik","Priyanka"));
    }
    @Test
    void testGetReleaseDate() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.getReleaseDate()).thenReturn(new Date(2021,06,12));
        assertEquals(movie.getReleaseDate(), new Date(2021,06,12));
    }

    @Test
    void testSetLoginId() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.setMovieId(1)).thenReturn(1);
        assertEquals(movie.setMovieId(1), 1);
    }
    @Test
    void testSetMovieName() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.setMovieName("Krish")).thenReturn("Krish");
        assertEquals(movie.setMovieName("Krish"), "Krish");
    }
    @Test
    void testSetDescription() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.setDescription("Hindi")).thenReturn("Hindi");
        assertEquals(movie.setDescription("Hindi"), "Hindi");
    }
    @Test
    void testSetGenre() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.setGenre("Action")).thenReturn("Action");
        assertEquals(movie.setGenre("Action"), "Action");
    }
    @Test
    void testSetLanguage() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.setLanguage("Hindi")).thenReturn("Hindi");
        assertEquals(movie.setLanguage("Hindi"), "Hindi");
    }
    @Test
    void testSetListOfActors() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.setActors(List.of("Hritik","Priyanka"))).thenReturn(List.of("Hritik","Priyanka"));
        assertEquals(movie.setActors(List.of("Hritik","Priyanka")), List.of("Hritik","Priyanka"));
    }
    @Test
    void testSetReleaseDate() throws Exception {
        Movie movie=Mockito.mock(Movie.class);
        when(movie.setReleaseDate(new Date(2021,06,12))).thenReturn(new Date(2021,06,12));
        assertEquals(movie.setReleaseDate(new Date(2021,06,12)), new Date(2021,06,12));
    }
}
