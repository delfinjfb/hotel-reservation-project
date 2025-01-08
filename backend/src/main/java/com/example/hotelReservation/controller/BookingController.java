package com.example.hotelReservation.controller;

import com.example.hotelReservation.dto.BookingDto;
import com.example.hotelReservation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for handling booking-related requests.
 *
 * <p>This class is marked final to indicate it is not designed for extension.
 * If extension is required, remove the 'final' keyword and provide
 * documentation explaining how to safely override methods.</p>
 */
@RestController
@RequestMapping("/api/bookings")
public final class BookingController {

    /**
     * Service for managing bookings.
     */
    private final BookingService bookingService;

    /**
     * Constructs a new BookingController with the given service.
     *
     * @param service the service to use for booking operations
     */
    @Autowired
    public BookingController(final BookingService service) {
        // Renamed parameter to avoid HiddenField violation
        this.bookingService = service;
    }

    /**
     * Retrieves all bookings.
     *
     * @return a list of {@link BookingDto} representing all bookings
     */
    @GetMapping
    public List<BookingDto> getAllBookings() {
        return bookingService.getAllBookings();
    }

    /**
     * Retrieves a booking by its ID.
     *
     * @param id the ID of the booking
     * @return the booking details as a {@link BookingDto}
     */
    @GetMapping("/{id}")
    public BookingDto getBooking(@PathVariable final Integer id) {
        return bookingService.getBookingById(id);
    }

    /**
     * Creates a new booking.
     *
     * @param bookingDto the {@link BookingDto} containing booking data
     * @return the created booking as a {@link BookingDto}
     */
    @PostMapping
    public BookingDto createBooking(@RequestBody final BookingDto bookingDto) {
        return bookingService.createBooking(bookingDto);
    }

    /**
     * Updates an existing booking by its ID.
     *
     * @param id         the ID of the booking to update
     * @param bookingDto the updated booking data
     * @return the updated booking as a {@link BookingDto}
     */
    @PutMapping("/{id}")
    public BookingDto updateBooking(@PathVariable final Integer id,
                                    @RequestBody final BookingDto bookingDto) {
        return bookingService.updateBooking(id, bookingDto);
    }

    /**
     * Deletes a booking by its ID.
     *
     * @param id the ID of the booking to delete
     */
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable final Integer id) {
        bookingService.deleteBooking(id);
    }
}
