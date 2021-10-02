package com.paypal.bfs.test.bookingserv.impl;

import java.util.List;

import javax.validation.Valid;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.service.BookingServiceI;

@RestController
public class BookingResourceImpl implements BookingResource {

	@Autowired
	BookingServiceI bookingService;
	
    @Override
    public ResponseEntity<Booking> create(@Valid Booking booking) {
    	try {
    		return new ResponseEntity<>(bookingService.createBooking(booking), HttpStatus.OK);
    	}catch(Exception ex) {
    		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    	}
        
    }
    
    @Override
    public ResponseEntity<List<Booking>> getBookings(){
    	try {
    		return new ResponseEntity<>(bookingService.getBookings(), HttpStatus.OK);
    	}catch(Exception ex) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }

//	@Override
//	public ResponseEntity<com.paypal.bfs.test.bookingserv.api.Booking> create(
//			com.paypal.bfs.test.bookingserv.api.Booking booking) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
