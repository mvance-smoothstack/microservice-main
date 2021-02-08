/**
 * 
 */
package com.ss.utopia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.model.Flights;
import com.ss.utopia.service.FlightService;


@RestController
@RequestMapping("/utopia/flights")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping(path = {"/", ""},produces= {"application/json", "application/xml"})
	public ResponseEntity<List<Flights>> getAllFlights(){
		return ResponseEntity.ok(flightService.getAllFlights());
	}
	
	@GetMapping(path = {"/number/{id}"},produces= {"application/json", "application/xml"})
	public ResponseEntity<Flights> getSpecificFlight(@PathVariable("id") String id){
		return flightService.getSpecificFlight(id)
				.map(x -> ResponseEntity.ok(x))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = {"/from/{airportid}"},produces= {"application/json", "application/xml"})
	public ResponseEntity<List<Flights>> getAllFlightsDepartingFromAirport(@PathVariable("airportid") String airportid){
		return ResponseEntity.ok(flightService.getAllFlightsDepartingFromAirport(airportid));
	}
	
	@GetMapping(path = {"/to/{airportid}"},produces= {"application/json", "application/xml"})
	public ResponseEntity<List<Flights>> getAllFlightsArrivingToAirport(@PathVariable("airportid") String airportid){
		return ResponseEntity.ok(flightService.getAllFlightsArrivingToAirport(airportid));
	}
	
	@GetMapping(path = {"/from/{airportid1}/to/{airportid2}"},produces= {"application/json", "application/xml"})
	public ResponseEntity<List<Flights>> getAllFlightsBetweenAirports(
			@PathVariable("airportid1") String airportid1,
			@PathVariable("airportid2") String airportid2)
	{
		return ResponseEntity.ok(flightService.getAllFlightsBetweenAirports(airportid1, airportid2));
	}

}
