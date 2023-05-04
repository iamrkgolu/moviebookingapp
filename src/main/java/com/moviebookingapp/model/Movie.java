package com.moviebookingapp.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Movie {
	@Id
	private int movieId;
	private String movieName;
	@Lob
	@Column(columnDefinition = "text")
	private String description;
	private String genre;
	private String language;
	private List<String> actors;
	@CreationTimestamp
	private Date releaseDate;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movie")
	private List<Ticket> ticket;

	
	
	

}
