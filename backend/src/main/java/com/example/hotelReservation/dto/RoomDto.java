package com.example.hotelReservation.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Data Transfer Object for room details.
 *
 * <p>Holds information about a room, including its ID, description,
 * size, type, capacity, number, and base price.</p>
 */
@Data
@Builder
public class RoomDto {

    /**
     * The unique identifier of the room.
     */
    private Integer id;

    /**
     * The description of the room.
     */
    private String roomDescription;

    /**
     * The size of the room in square meters.
     */
    private Integer roomSize;

    /**
     * The type of the room (e.g., "Single", "Double").
     */
    private String roomType;

    /**
     * The maximum number of persons the room can accommodate.
     */
    private Integer roomMaxPersons;

    /**
     * The room number.
     */
    private String roomNumber;

    /**
     * The base price of the room.
     */
    private BigDecimal basePrice;

    /**
     * Category Room from entity RoomCategory
     */
    private RoomCategoryDTO roomCategory;   // Include room category name
}
