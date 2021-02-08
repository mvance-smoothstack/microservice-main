/**
 * 
 */
package com.ss.utopia.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jordandivina
 *
 */

@Entity
@Table(name="airports")
public class Airports implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(name="airport_code")
    private String airportCode;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "name")
    private String name;
    
    
	@Override
	public String toString() {
		return "Airports [airportCode=" + airportCode + ", city=" + city + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airportCode == null) ? 0 : airportCode.hashCode());
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
		Airports other = (Airports) obj;
		if (airportCode == null) {
			if (other.airportCode != null)
				return false;
		} else if (!airportCode.equals(other.airportCode))
			return false;
		return true;
	}

	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
