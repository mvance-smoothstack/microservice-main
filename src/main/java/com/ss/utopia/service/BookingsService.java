/**
 * 
 */
package com.ss.utopia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.utopia.dao.BookingsDAO;
import com.ss.utopia.model.Bookings;

/**
 * @author max
 *
 */
@Service
public class BookingsService {
	
	@Autowired
	private BookingsDAO bookingsDAO;

	public Bookings getBookingById(int bookingId) {
		Optional<Bookings> found = bookingsDAO.findById(bookingId);
		if (found.isPresent()) {
			return found.get();
		} else {
			return null;
		}
	}
	
	public void insertBooking(Bookings booking) {
		bookingsDAO.save(booking);
	}
	
	public int nextId() {
		return (bookingsDAO.getMaxId() + 1);
	}
	
}
