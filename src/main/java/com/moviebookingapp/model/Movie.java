package com.moviebookingapp.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;
import org.springframework.data.annotation.ReadOnlyProperty;

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
