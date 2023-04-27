package com.moviebookingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingapp.model.Ticket;
import com.moviebookingapp.repository.TicketRepository;

@Service
public class TicketServiceImplementation implements TicketService{
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private MovieService movieService;

	@Override
	public Object bookTicket(String movieName, Ticket ticket) {
		if(movieService.getMovieByMovieName(movieName)!=null) {
			ticket.setMovieName(movieName);
			return ticketRepository.save(ticket);
		}
		return null;
	}

	@Override
	public List<Ticket> getAllTicket() {
		return ticketRepository.findAll();
	}

	@Override
	public boolean deleteTicket(int ticketId) {
		Optional<Ticket> findById = ticketRepository.findById(ticketId);
		if(findById.isPresent()) {
			ticketRepository.deleteById(ticketId);
			return true;
		}else {
			return false;
	}}

	@Override
	public Object updateMovie(int ticketId, String moviename, Ticket ticket) {
		Ticket findedTicket=ticketRepository.findByTransactionIdAndMovieName(ticketId,moviename);
		if(findedTicket!=null) {
			findedTicket.setAddress(ticket.getAddress());
			findedTicket.setMovieName(moviename);
			findedTicket.setTheaterName(ticket.getTheaterName());
			findedTicket.setTransactionId(ticketId);
			ticketRepository.save(findedTicket);
			ticket.setBookingDate(findedTicket.getBookingDate());
			ticket.setBookingTime(findedTicket.getBookingTime());
			return "Data Save";
		}
		return null;
	}

	@Override
	public List<Ticket> getTicketByMovieName(String moviename) {
		List<Ticket>findedTicket=ticketRepository.findByMovieName(moviename);
		if(findedTicket!=null) {
			return findedTicket;
		}else {
			return null;	
		}
		
	}

}
