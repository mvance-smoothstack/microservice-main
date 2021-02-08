/**
 * 
 */
package com.ss.utopia.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 * 
 * @author alex
 *
 */

@Entity
@Table(name="flights_instance")
public class Flights implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(name="id")
    private int id;
    @Column
    private Timestamp departure_time;
    @Column
    private int capacity;
    @Column
    private BigDecimal price;
    @Column
    private Timestamp arrival_time;
    @Column
    private String flight_number;
    @ManyToMany
	@JoinTable(
			name = "flights_has_bookings",
			joinColumns = @JoinColumn(name = "flights_id"),
			inverseJoinColumns = @JoinColumn(name = "bookings_id"))
	private List<Bookings> bookings;
    
    @Column
    private String arrival_city;
    @Column
    private String departure_city;
    
    public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}

	public void setDeparture_city(String departure_city) {
		this.departure_city = departure_city;
	}

	public String getArrival_city() {
		return arrival_city;
	}


	public String getDeparture_city() {
		return departure_city;
	}
  
	@Override
	public String toString() {
		return "Flights [id=" + id + ", departure_time=" + departure_time + ", capacity=" + capacity + ", price="
				+ price + ", arrival_time=" + arrival_time + ", flight_number=" + flight_number + ", arrival_city="
				+ arrival_city + ", departure_city=" + departure_city + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Timestamp getDeparture_time() {
		return departure_time;
	}


	public void setDeparture_time(Timestamp departure_time) {
		this.departure_time = departure_time;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public Timestamp getArrival_time() {
		return arrival_time;
	}


	public void setArrival_time(Timestamp arrival_time) {
		this.arrival_time = arrival_time;
	}


	public String getFlight_number() {
		return flight_number;
	}


	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival_city == null) ? 0 : arrival_city.hashCode());
		result = prime * result + ((arrival_time == null) ? 0 : arrival_time.hashCode());
		result = prime * result + capacity;
		result = prime * result + ((departure_city == null) ? 0 : departure_city.hashCode());
		result = prime * result + ((departure_time == null) ? 0 : departure_time.hashCode());
		result = prime * result + ((flight_number == null) ? 0 : flight_number.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flights other = (Flights) obj;
		if (arrival_city == null) {
			if (other.arrival_city != null)
				return false;
		} else if (!arrival_city.equals(other.arrival_city))
			return false;
		if (arrival_time == null) {
			if (other.arrival_time != null)
				return false;
		} else if (!arrival_time.equals(other.arrival_time))
			return false;
		if (capacity != other.capacity)
			return false;
		if (departure_city == null) {
			if (other.departure_city != null)
				return false;
		} else if (!departure_city.equals(other.departure_city))
			return false;
		if (departure_time == null) {
			if (other.departure_time != null)
				return false;
		} else if (!departure_time.equals(other.departure_time))
			return false;
		if (flight_number == null) {
			if (other.flight_number != null)
				return false;
		} else if (!flight_number.equals(other.flight_number))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
}
