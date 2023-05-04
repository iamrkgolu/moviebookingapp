package com.moviebookingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingapp.model.Movie;
import com.moviebookingapp.model.Ticket;
import com.moviebookingapp.repository.TicketRepository;

@Service
public class TicketServiceImplementation implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private MovieService movieService;

	@Override
	public Object bookTicket(String movieName, Ticket ticket) {
		Movie movie = movieService.getMovieByMovieName(movieName);
		int bookedSeat = getAvailableSeatByMovieName(movieName);
		System.out.println(bookedSeat);
		int totalBookedSeat=bookedSeat+ticket.getSeatBooked();
		if ((movie != null) && ((totalBookedSeat <= 100))) {
			ticket.setMovieName(movieName);
			ticket.setRemaining(100-(ticket.getSeatBooked()));
			ticket.setMovie(movie);
			ticket.setCapacity(100);
			return this.ticketRepository.saveAndFlush(ticket);
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
		if (findById.isPresent()) {
			ticketRepository.deleteById(ticketId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object updateMovie(int ticketId, String moviename, Ticket ticket) {
		Ticket findedTicket = ticketRepository.findByTransactionIdAndMovieName(ticketId, moviename);
		if (findedTicket != null) {
			findedTicket.setAddress(ticket.getAddress());
			findedTicket.setMovieName(moviename);
			findedTicket.setTheaterName(ticket.getTheaterName());
			findedTicket.setTransactionId(ticketId);
			ticketRepository.saveAndFlush(findedTicket);
			ticket.setBookingDate(findedTicket.getBookingDate());
			ticket.setBookingTime(findedTicket.getBookingTime());
			return "Data Save";
		}
		return null;
	}

	@Override
	public List<Ticket> getTicketByMovieName(String moviename) {
		List<Ticket> findedTicket = ticketRepository.findByMovieName(moviename);
		if (findedTicket != null) {
			return findedTicket;
		}
		return null;
	}

	@Override
	public int getAvailableSeatByMovieName(String movie) {
		Integer bookedSeat = ticketRepository.totalBookingForMovie(movie);
		if(bookedSeat!=null){
			return bookedSeat;
		}else{
			bookedSeat=0;
			return bookedSeat;
		}
	}
}
