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
	private int totalSeatBooked;
	private int availableSeatsForBooking;

	

	public int getAvailableSeatsForBooking() {
		return availableSeatsForBooking;
	}

	public void setAvailableSeatsForBooking(int availableSeatsForBooking) {
		this.availableSeatsForBooking = availableSeatsForBooking;
	}

	public int getTotalSeatBooked() {
		return totalSeatBooked;
	}

	public void setTotalSeatBooked(int totalSeatBooked) {
		this.totalSeatBooked = totalSeatBooked;
	}

	public int getMovieId() {
		return movieId;
	}

	public int setMovieId(int movieId) {
		this.movieId = movieId;
		return movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public String setMovieName(String movieName) {
		this.movieName = movieName;
		return movieName;
	}

	public String getDescription() {
		return description;
	}

	public String setDescription(String description) {
		this.description = description;
		return description;
	}

	public String getGenre() {
		return genre;
	}

	public String setGenre(String genre) {
		this.genre = genre;
		return genre;
	}

	public String getLanguage() {
		return language;
	}

	public String setLanguage(String language) {
		this.language = language;
		return language;
	}

	public List<String> getActors() {
		return actors;
	}

	public List<String> setActors(List<String> actors) {
		this.actors = actors;
		return actors;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public Date setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
		return releaseDate;
	}

	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}
}
