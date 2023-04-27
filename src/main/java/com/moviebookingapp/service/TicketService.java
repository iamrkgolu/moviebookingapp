package com.moviebookingapp.service;

import java.util.List;

import com.moviebookingapp.model.Ticket;

public interface TicketService {

	Object bookTicket(String movieName, Ticket ticket);

	List<Ticket> getAllTicket();

	boolean deleteTicket(int ticketId);

	Object updateMovie(int ticketId, String moviename, Ticket ticket);

	List<Ticket> getTicketByMovieName(String moviename);

//	boolean deleteTicketByMovie(String movie);
	
	

}
