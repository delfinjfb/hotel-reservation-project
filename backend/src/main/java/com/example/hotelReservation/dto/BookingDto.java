package com.example.hotelReservation.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * Data Transfer Object for booking details.
 *
 * <p>Holds information about a booking, including room, customer, date range,
 * total price, and applied season details.</p>
 */
@Data
@Builder
public class BookingDto {

    /**
     * The unique identifier of the booking.
     */
    private Integer id;

    /**
     * The ID of the room associated with the booking.
     *
     * <p>This is a reference to the room; the actual Booking entity will
     * have a Room object.</p>
     */
    private Integer roomId;

    /**
     * The ID of the customer associated with the booking.
     */
    private Integer customerId;

    /**
     * The start date of the booking.
     */
    private LocalDate startDate;

    /**
     * The end date of the booking.
     */
    private LocalDate endDate;

    /**
     * The total price of the booking.
     *
     * <p>Stored as a {@code Double} for convenience.</p>
     */
    private Double totalPrice;

    /**
     * The status of the booking (e.g., "confirmed", "cancelled").
     */
    private String status;

    /**
     * The ID of the season applied to the booking.
     */
    private Integer appliedSeasonId;

    /**
     * The price multiplier applied to the booking.
     */
    private Double appliedMultiplier;

    /**
     * The name of the season applied to the booking.
     */
    private String appliedSeasonName;
}
