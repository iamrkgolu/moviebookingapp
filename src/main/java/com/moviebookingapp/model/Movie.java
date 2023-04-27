package com.moviebookingapp.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
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
	private String theatre;
	private BigDecimal totalNoOfTicketAlloated;
	private int ticketId;

	
	
	

}
