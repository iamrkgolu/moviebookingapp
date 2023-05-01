package com.moviebookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moviebookingapp.model.Movie;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	Movie findByMovieName(String movieName);
	@Query("select m.movieName  from Movie m ")
	List<String> moviesName();

}
