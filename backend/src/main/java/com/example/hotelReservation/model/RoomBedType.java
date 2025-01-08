package com.example.hotelReservation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a type of bed associated with a room in the Hotel Reservation
 * system.
 *
 * <p>Each entry specifies the type of bed available in a room.</p>
 */
@Entity
@Table(name = "room_bed_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomBedType {

    /**
     * The unique identifier for the room bed type.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The type of bed available in the room (e.g., "Single Bed", "Double Bed").
     */
    @Column(name = "bed_type", nullable = false)
    private String bedType;
}
