package com.moviebookingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Movie {
	@Id
	private int movieId;
	private String movieName;
	private String theatreName;
	private int totalNoOfTicketAlloated;
	

}
