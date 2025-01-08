package com.example.hotelReservation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Represents a booking in the Hotel Reservation system.
 */
@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Booking {

    /**
     * The unique identifier for the booking.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The room associated with the booking.
     */
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    /**
     * The customer ID for the booking.
     */
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    /**
     * The start date of the booking.
     */
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    /**
     * The end date of the booking.
     */
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    /**
     * The total price of the booking.
     */
    @Column(name = "total_price", nullable = false,
            precision = TOTAL_PRICE_PRECISION, scale = TOTAL_PRICE_SCALE)
    private BigDecimal totalPrice;

    /**
     * The status of the booking.
     */
    @Builder.Default
    @Column(name = "status", length = STATUS_MAX_LENGTH)
    private String status = "Booked";

    /**
     * The season ID applied to the booking.
     */
    @Column(name = "applied_season_id")
    private Integer appliedSeasonId;

    /**
     * The multiplier applied during the season.
     */
    @Column(name = "applied_multiplier", precision = MULTIPLIER_PRECISION,
            scale = MULTIPLIER_SCALE)
    private BigDecimal appliedMultiplier;

    /**
     * The name of the season applied to the booking.
     */
    @Column(name = "applied_season_name", length = SEASON_NAME_MAX_LENGTH)
    private String appliedSeasonName;

    /**
     * The timestamp when the booking was created.
     */
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * The timestamp when the booking was last updated.
     */
    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    /**
     * Constants for field STATUS_MAX_LENGTH.
     */
    public static final int STATUS_MAX_LENGTH = 20;
    /**
     * Constants for field SEASON_NAME_MAX_LENGTH.
     */
    public static final int SEASON_NAME_MAX_LENGTH = 100;
    /**
     * Constants for field MULTIPLIER_PRECISION.
     */
    public static final int MULTIPLIER_PRECISION = 4;
    /**
     * Constants for field MULTIPLIER_SCALE.
     */
    public static final int MULTIPLIER_SCALE = 2;
    /**
     * Constants for field TOTAL_PRICE_PRECISION.
     */
    public static final int TOTAL_PRICE_PRECISION = 10;
    /**
     * Constants for field TOTAL_PRICE_SCALE.
     */
    public static final int TOTAL_PRICE_SCALE = 2;
}
