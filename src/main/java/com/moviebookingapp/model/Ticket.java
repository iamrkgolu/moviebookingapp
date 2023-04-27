package com.moviebookingapp.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	@NotNull
	private String movieName;
	@NotNull
	private String theaterName;
	private BigDecimal capacity;
	@NotNull
	private BigDecimal seatBooked;
	private BigDecimal remaining;
	private String address;
	
	@UpdateTimestamp
	private Date bookingDate;
	@UpdateTimestamp
	private Time bookingTime;


}
