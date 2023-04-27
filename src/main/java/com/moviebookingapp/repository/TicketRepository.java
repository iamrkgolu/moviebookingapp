package com.moviebookingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingapp.model.Ticket;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	Ticket findByTransactionIdAndMovieName(int ticketId, String moviename);

	List<Ticket> findByMovieName(String moviename);

}
