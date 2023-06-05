package com.moviebookingapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.moviebookingapp.exceptions.MovieIdAlreadyExistsExceptions;
import com.moviebookingapp.model.Ticket;
import com.moviebookingapp.service.TicketService;

@RestController
@RequestMapping(value = "/api/v1.0/moviebooking")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping(value = "/{movieName}/book")
    public ResponseEntity<?> bookTicket(@PathVariable("movieName") String movieName, @RequestBody Ticket ticket) throws MovieIdAlreadyExistsExceptions {
        if (ticketService.bookTicket(movieName, ticket) != null) {
            ticket.setMovieName(movieName);
            return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
        }

        return new ResponseEntity<String>("Movie object is null", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/ticket/all")
    public ResponseEntity<?> getAllTicket() {
        List<Ticket> ticketList = ticketService.getAllTicket();
        if (ticketList != null) {
            return new ResponseEntity<List<Ticket>>(ticketList, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Ticket List Empty!!", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/user/delete/{ticketId}")
    public ResponseEntity<?> deleteMovie(@PathVariable("ticketId") int ticketId) {
        if (ticketService.deleteTicket(ticketId)) {
            return new ResponseEntity<String>("Ticket got deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Ticket did not get deleted ", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{moviename}/update/{ticketId}")
    public ResponseEntity<?> updateMovie(@PathVariable("moviename") String moviename, @PathVariable("ticketId") int ticketId, @RequestBody Ticket ticket) throws MovieIdAlreadyExistsExceptions {
        if (ticketService.updateMovie(ticketId, moviename, ticket) != null) {
            ticket.setMovieName(moviename);
            ticket.setTransactionId(ticketId);
            return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("No Ticket Found with Ticket id and movie name", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/search/ticket/{moviename}")
    public ResponseEntity<?> getTicketByMovieName(@PathVariable("moviename") String moviename) {
        List<Ticket> ticketList = ticketService.getTicketByMovieName(moviename);
        if (ticketList != null) {
            return new ResponseEntity<List<Ticket>>(ticketList, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Ticket List Empty!!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/check/available/seat/{movie}")
    public ResponseEntity<?> getAvailableSeatByMovieName(@PathVariable("movie") String movie) {
        int seat = ticketService.getAvailableSeatByMovieName(movie);
        if (seat < 100) {
            return new ResponseEntity<Integer>(100 - seat, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Seat Full Or Movie Does not Exit...", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
