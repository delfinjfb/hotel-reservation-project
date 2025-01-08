package com.example.hotelReservation.service;

import com.example.hotelReservation.dto.BookingDto;
import com.example.hotelReservation.model.Booking;
import com.example.hotelReservation.model.Room;
import com.example.hotelReservation.repository.BookingRepository;
import com.example.hotelReservation.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing bookings in the Hotel Reservation system.
 */
@Service
public final class BookingService {

    /**
     * Repository for accessing booking data.
     */
    private final BookingRepository bookingRepository;

    /**
     * Repository for accessing room data.
     */
    private final RoomRepository roomRepository;

    /**
     * Mapper for converting between entities and DTOs.
     */
    private final DtoMapper dtoMapper;

    /**
     * Constructor for BookingService.
     *
     * @param bookingRepo the booking repository
     * @param roomRepo    the room repository
     * @param mapper      the DTO mapper
     */
    public BookingService(
            final BookingRepository bookingRepo,
            final RoomRepository roomRepo,
            final DtoMapper mapper) {
        this.bookingRepository = bookingRepo;
        this.roomRepository = roomRepo;
        this.dtoMapper = mapper;
    }

    /**
     * Retrieves all bookings.
     *
     * @return a list of booking DTOs
     */
    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(dtoMapper::toBookingDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a booking by its ID.
     *
     * @param id the ID of the booking
     * @return the booking DTO
     */
    public BookingDto getBookingById(final Integer id) {
        return bookingRepository.findById(id)
                .map(dtoMapper::toBookingDto)
                .orElseThrow(() -> new RuntimeException(
                        "Booking not found with id " + id));
    }

    /**
     * Creates a new booking.
     *
     * @param bookingDto the booking DTO
     * @return the created booking DTO
     */
    public BookingDto createBooking(final BookingDto bookingDto) {
        Booking booking = dtoMapper.toBookingEntity(bookingDto);

        if (bookingDto.getRoomId() != null) {
            Room room = roomRepository.findById(bookingDto.getRoomId())
                    .orElseThrow(() -> new RuntimeException(
                            "Room not found with id: "
                                    + bookingDto.getRoomId()));
            booking.setRoom(room);
        }

        Booking savedBooking = bookingRepository.save(booking);
        return dtoMapper.toBookingDto(savedBooking);
    }

    /**
     * Updates an existing booking.
     *
     * @param id         the ID of the booking to update
     * @param bookingDto the updated booking DTO
     * @return the updated booking DTO
     */
    public BookingDto updateBooking(final Integer id,
                                    final BookingDto bookingDto) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Booking not found with id " + id));

        existingBooking.setStartDate(bookingDto.getStartDate());
        existingBooking.setEndDate(bookingDto.getEndDate());
        existingBooking.setStatus(bookingDto.getStatus());

        if (bookingDto.getTotalPrice() != null) {
            existingBooking.setTotalPrice(
                    BigDecimal.valueOf(bookingDto.getTotalPrice()));
        }

        if (bookingDto.getRoomId() != null) {
            Room room = roomRepository.findById(bookingDto.getRoomId())
                    .orElseThrow(() -> new RuntimeException(
                            "Room not found with id: "
                                    + bookingDto.getRoomId()));
            existingBooking.setRoom(room);
        }

        existingBooking.setAppliedSeasonId(bookingDto.getAppliedSeasonId());
        existingBooking.setAppliedSeasonName(bookingDto.getAppliedSeasonName());
        if (bookingDto.getAppliedMultiplier() != null) {
            existingBooking.setAppliedMultiplier(
                    BigDecimal.valueOf(bookingDto.getAppliedMultiplier()));
        }

        Booking updatedBooking = bookingRepository.save(existingBooking);
        return dtoMapper.toBookingDto(updatedBooking);
    }

    /**
     * Deletes a booking by its ID.
     *
     * @param id the ID of the booking to delete
     */
    public void deleteBooking(final Integer id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found with id " + id);
        }
        bookingRepository.deleteById(id);
    }
}
