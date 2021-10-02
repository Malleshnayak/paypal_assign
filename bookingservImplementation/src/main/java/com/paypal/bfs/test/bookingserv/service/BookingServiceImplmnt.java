package com.paypal.bfs.test.bookingserv.service;

import java.util.List;

import javax.transaction.Transactional;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.bookingserv.exception.BookingAlreadyExists;
import com.paypal.bfs.test.bookingserv.exception.InValidBooking;
import com.paypal.bfs.test.bookingserv.exception.NoBookingFound;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;

import lombok.extern.log4j.Log4j2;

@Transactional
@Service
@Log4j2
public class BookingServiceImplmnt implements BookingServiceI {
	@Autowired
	private BookingRepository bookingRepo;

	@Override
	public com.paypal.bfs.test.bookingserv.api.model.Booking createBooking(Booking booking) throws InValidBooking, Exception {
		if(booking == null) {
			throw new InValidBooking("Invalid Booking");
		}
		try {
//			if(booking.getId() > 0) { //Idempotency check performance
//				Booking tempBooking = bookingRepo.findById(booking.getId()).get();
//				if(tempBooking == null) {
//					throw new BookingAlreadyExists("Booking already exists");
//				}
//			}
			
			return bookingRepo.saveAndFlush(booking);
		}catch(Exception ex) {
			log.error("Exception occured in Booking creation"+ex.getMessage());
			throw ex;
		}
	}

	@Override
	public List<Booking> getBookings() throws NoBookingFound, Exception {
		try {
			List<Booking> bookings = bookingRepo.findAll();
			if(bookings == null || bookings.isEmpty()) {
				throw new NoBookingFound("No Booking found");
			}
			return bookings;
		}catch(Exception ex) {
			log.error("Exception occured in Booking creation"+ex.getMessage());
			throw ex;
		}
	}
	
	
	
}
