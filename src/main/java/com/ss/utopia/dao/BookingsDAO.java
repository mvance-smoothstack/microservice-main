/**
 * 
 */
package com.ss.utopia.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ss.utopia.model.Bookings;

/**
 * @author max
 *
 */
@Repository
public interface BookingsDAO extends JpaRepository<Bookings, Integer> {
	
	@Query(value="SELECT MAX(id) FROM bookings", nativeQuery=true)
	int getMaxId();
	
}
