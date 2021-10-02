package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exception.NoBookingFound;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.paypal.bfs.test.bookingserv.exception.InValidBooking;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.service.BookingServiceI;
import com.paypal.bfs.test.bookingserv.service.BookingServiceImplmnt;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BookingServiceImplmnt.class)
public class BookingResourceTest {

	@Autowired
	private BookingServiceI bookingService = new BookingServiceImplmnt();
	
	@MockBean
	private BookingRepository bookingRepo;
	
	@Test
	public void testCreate() throws InValidBooking, Exception {
		Booking booking = new Booking();
		booking.setId(12);
		booking.setFirstName("mallesh");
		booking.setLastName("gugloth");
		when(bookingRepo.findById(12)).thenReturn(booking);
		when(bookingRepo.saveAndFlush(booking)).thenReturn(booking);
		
		Booking tempBook = bookingService.createBooking(booking);
		assertNotNull(tempBook);
		assertEquals(tempBook, booking);
		assertEquals(Optional.of(12), Optional.of(tempBook.getId()));
//		assertThatExceptionOfType(InValidBooking.class);
//		assertThrown(bookingService.createBooking(null));
		
	}
	
	@Test
	public void testBookings() throws NoBookingFound,Exception {
		Booking booking = new Booking();
		booking.setId(12);
		booking.setFirstName("mallesh");
		booking.setLastName("gugloth");
		Booking booking2 = new Booking();
		booking.setId(123);
		booking.setFirstName("mallesh1");
		booking.setLastName("gugloth1");
		when(bookingRepo.findAll()).thenReturn(Arrays.asList(booking,booking2));
		
		List<Booking> bookings = bookingService.getBookings();
		
		assertNotNull(bookings);
		assertEquals(2, bookings.size());
//		assertEquals(java.util.Optional.of(123), bookings.get(0).getId());
		
	}
}
