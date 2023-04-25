package com.moviebookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingapp.model.Movie;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
