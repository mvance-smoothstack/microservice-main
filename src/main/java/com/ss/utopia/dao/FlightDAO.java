/**
 * 
 */
package com.ss.utopia.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ss.utopia.model.Flights;


@Repository
public interface FlightDAO extends JpaRepository<Flights, Integer>{
	
	@Query(value="SELECT f.* FROM flights_instance f WHERE f.departure_city = ?1", nativeQuery=true) // native query so mysql syntax works, TODO find out the generic syntax
	List<Flights> getAllFlightsDepartingFromAirport(String airportid);
	
	@Query(value="SELECT f.* FROM flights_instance f WHERE f.arrival_city = ?1", nativeQuery=true) // native query so mysql syntax works
	List<Flights> getAllFlightsArrivingToAirport(String airportid);
	
	@Query(value="SELECT f.* FROM flights_instance f WHERE f.departure_city = ?1 and f.arrival_city = ?2", nativeQuery=true) // native query so mysql syntax works
	List<Flights> getAllFlightsBetweenAirports(String airportid1, String airportid2);

	@Query(value="SELECT f.* FROM flights_instance f WHERE f.flight_number = ?1", nativeQuery=true) // native query so mysql syntax works
	Flights getFlightWithNumber(String number);
}
