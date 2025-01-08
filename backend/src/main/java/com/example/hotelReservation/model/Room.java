package com.example.hotelReservation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a room in the Hotel Reservation system.
 *
 * <p>Each room has details such as its number, size, type, and price,
 * and belongs to a specific category.</p>
 */
@Entity
@Table(name = "rooms")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Room {

    /**
     * The unique identifier for the room.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The unique room number.
     */
    @Column(name = "room_number", nullable = false, unique = true)
    private String roomNumber;

    /**
     * A detailed description of the room.
     */
    @Column(name = "room_description", nullable = false,
            columnDefinition = "TEXT")
    private String roomDescription;

    /**
     * The size of the room in square meters.
     */
    @Column(name = "room_size", nullable = false)
    private Integer roomSize;

    /**
     * The type of the room (e.g., "Single", "Double").
     */
    @Column(name = "room_type", nullable = false)
    private String roomType;

    /**
     * The maximum number of persons the room can accommodate.
     */
    @Column(name = "room_max_persons", nullable = false)
    private Integer roomMaxPersons;

    /**
     * The base price of the room per night.
     */
    @Column(name = "base_price", nullable = false,
            precision = BASE_PRICE_PRECISION, scale = BASE_PRICE_SCALE)
    private BigDecimal basePrice;

    /**
     * The category to which the room belongs.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_category_id", nullable = false)
    private RoomCategory roomCategory;

    /**
     * The timestamp when the room record was created.
     */
    @Column(name = "created_at", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    /**
     * The timestamp when the room record was last updated.
     */
    @Column(name = "updated_at",
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    /**
     * Sets the createdAt field to the current timestamp before persisting.
     */
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Sets the updatedAt field to the current timestamp before updating.
     */
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Precision for the base price field.
     */
    public static final int BASE_PRICE_PRECISION = 10;

    /**
     * Scale for the base price field.
     */
    public static final int BASE_PRICE_SCALE = 2;
}
