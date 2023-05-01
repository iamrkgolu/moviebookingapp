package com.moviebookingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.moviebookingapp.model.Ticket;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query("select sum( t.seatBooked)  from Ticket t where t.movieName = :movie_name")
	Integer totalBookingForMovie(@Param("movie_name") String movieName);

	Ticket findByTransactionIdAndMovieName(int ticketId, String moviename);

	List<Ticket> findByMovieName(String moviename);

}
