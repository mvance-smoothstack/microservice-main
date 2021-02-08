/**
 * 
 */
package com.ss.utopia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ss.utopia.service.BookingsService;
import com.ss.utopia.service.FlightService;
import com.ss.utopia.model.Bookings;
import com.ss.utopia.model.Flights;

/**
 * @author max
 *
 */
@RestController
@RequestMapping("/utopia/bookings")
public class BookingsController {
	
	@Autowired
	private BookingsService bookingsService;	//pulls in the DAO
	@Autowired
	private FlightService flightService;
	
	@GetMapping(path = {"/{bookingId}"},produces= {"application/json", "application/xml"})
	public ResponseEntity<Bookings> getBookingById(@PathVariable("bookingId") int bookingId) {
		Bookings myBooking = bookingsService.getBookingById(bookingId);
		if (myBooking == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok(myBooking);
		}
	}
	
	@PostMapping(path = {"/flight/{flightId}"}, produces= {"application/json", "application/xml"})
	public ResponseEntity<Bookings> createBooking(@PathVariable("flightId") int flightId) {
		Flights myFlight = flightService.getFlightById(flightId);
		if (myFlight == null) {
			//no flight by that id
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		//Hardcoding dummy data in for the sake of making bookings work.
		//TODO: Make this not use dummy users, etc., once users and travelers and so forth are implemented.
		int newId = bookingsService.nextId();
		List<Flights> myFlightList = new ArrayList<Flights>();
		myFlightList.add(myFlight);
		Bookings newBooking = new Bookings(newId, 1, 1, myFlightList);
		bookingsService.insertBooking(newBooking);
		
		//now retrieve it to make sure it got saved correctly
		Bookings myNewBooking = bookingsService.getBookingById(newId);
		if (myNewBooking == null) {
			//return 500 error if saving failed somehow
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return ResponseEntity.ok(myNewBooking);
		}
	}
}
