package com.paypal.bfs.test.bookingserv.service;

import java.util.List;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.stereotype.Component;

import com.paypal.bfs.test.bookingserv.exception.InValidBooking;
import com.paypal.bfs.test.bookingserv.exception.NoBookingFound;

@Component
public interface BookingServiceI {
	public Booking createBooking(Booking booking) throws InValidBooking, Exception;
	public List<Booking> getBookings() throws NoBookingFound, Exception;
}
