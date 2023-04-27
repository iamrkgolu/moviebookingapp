package com.moviebookingapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Movie {
	@Id
	private int movieId;
	private String movieName;
	@OneToMany(targetEntity = Ticket.class)
	private List<Ticket> ticket;

	
	
	

}
