/**
 * 
 */
package com.ss.utopia.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ss.utopia.model.Flights;
import com.ss.utopia.service.FlightService;


@RestController
@RequestMapping("/utopia/flights")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping(path = {"/", ""},produces= {"application/json", "application/xml"})
	public ResponseEntity<List<Flights>> getAllAirports(){
		return ResponseEntity.ok(flightService.getAllFlights());
	}
	
	@GetMapping(path = {"/from/{airportid}"},produces= {"application/json", "application/xml"})
	public ResponseEntity<List<Flights>> getAllFlightsDepartingFromAirport(@PathVariable("airportid") String airportid){
		List<Flights> tempList = flightService.getAllFlightsDepartingFromAirport(airportid);
		return ResponseEntity.ok(tempList);
	}
	
//	@GetMapping(path = {"/to/{airportid}"},produces= {"application/json", "application/xml"})
//	public ResponseEntity<List<Flights>> getAllFlightsArrivingToAirport(@PathVariable("airportid") String airportid){
//		List<Flights> tempList = flightService.getAllFlightsArrivingToAirport(airportid);
//		return ResponseEntity.ok(tempList);
//	}	

}
