/**
 * 
 */
package com.ss.utopia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.model.Bookings;
import com.ss.utopia.model.Flights;

/**
 * @author jordandivina
 *
 */

@Service
public class FlightService {
	
	@Autowired
	private FlightDAO flightDAO;

	public List<Flights> getAllFlights() {
		return flightDAO.findAll();
	}
	
	public Flights getFlightById(int flightId) {
		Optional<Flights> found = flightDAO.findById(flightId);
		if (found.isPresent()) {
			return found.get();
		} else {
			return null;
		}
	}
	
	public Optional<Flights> getSpecificFlight(String Number){
		return Optional.ofNullable(flightDAO.getFlightWithNumber(Number.toUpperCase())); // .toUpperCase() used to add case-insensitivity
	}
	
	public List<Flights> getAllFlightsDepartingFromAirport(String airportid){
		return flightDAO.getAllFlightsDepartingFromAirport(airportid.toUpperCase());
	}
	
	public List<Flights> getAllFlightsArrivingToAirport(String airportid){
		return flightDAO.getAllFlightsArrivingToAirport(airportid.toUpperCase());
	}

	public List<Flights> getAllFlightsBetweenAirports(String airportid1, String airportid2){
		return flightDAO.getAllFlightsBetweenAirports(airportid1.toUpperCase(), airportid2.toUpperCase());
	}

	public String addAirport(Flights newAirport) {
		try {
			flightDAO.save(newAirport);
			return "Success in adding" + newAirport.toString();
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not add " + newAirport.toString());
		}
	}

	public String updateAirport(Flights newAirport) {
		try {
			flightDAO.save(newAirport);
			return "Updated " + newAirport.toString();
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not update " + newAirport.toString());
		}
	}

	public String deleteAirport(Flights newAirport) {
		try {
			flightDAO.delete(newAirport);
			return "Deleted " + newAirport.toString();
		}
		catch(DataIntegrityViolationException e){
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Current airport is still in use. Please try again later " + newAirport.toString());
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not delete " + newAirport.toString());
		}
	}


}
