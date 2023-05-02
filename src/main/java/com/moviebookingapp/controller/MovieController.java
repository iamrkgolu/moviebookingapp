package com.moviebookingapp.controller;

import com.moviebookingapp.exceptions.MovieIdAlreadyExistsExceptions;
import com.moviebookingapp.model.Movie;
import com.moviebookingapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<?> getMovieById(@PathVariable("movieId") int movieId) {
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
    public ResponseEntity<?> deleteMovie(@PathVariable("movieId") int movieId) {
        if (movieService.deleteMovie(movieId)) {
            return new ResponseEntity<String>("Movie got deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Movie did not get deleted ", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/admin/{movieName}/update")
    public ResponseEntity<?> updateMovie(@PathVariable("movieName") String movieName, @RequestBody Movie movie)
            throws MovieIdAlreadyExistsExceptions {
        if (movieService.updateMovie(movieName, movie) != null) {
            Movie movieByMovieName = movieService.getMovieByMovieName(movieName);
            movie.setMovieName(movieName);
            movie.setMovieId(movieByMovieName.getMovieId());
            movie.setReleaseDate(movieByMovieName.getReleaseDate());
            return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("No Movie Found with movie name", HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/movies/search/all")
    public ResponseEntity<?> getMoviesList() {
        List<String> movieList = movieService.getMoviesList();
        if (movieList != null) {
            return new ResponseEntity<List<String>>(movieList, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Movies List Empty!!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
