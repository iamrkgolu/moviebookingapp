package com.moviebookingapp.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {
	@Id
	private int movieId;
	private String movieName;
	@CreationTimestamp
	private Date releaseDate;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movie")
	private List<Ticket> ticket;
	private int totalSeat;
	private int totalSeatBooked;
	private int availableSeatsForBooking;
	
	

	

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

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
