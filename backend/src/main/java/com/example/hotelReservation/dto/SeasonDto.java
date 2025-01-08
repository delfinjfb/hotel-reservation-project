package com.example.hotelReservation.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Data Transfer Object for season details.
 *
 * <p>Holds information about a season, including its ID, name, start
 * and end dates, price multiplier, and active status.</p>
 */
@Data
@Builder
public class SeasonDto {

    /**
     * The unique identifier of the season.
     */
    private Integer id;

    /**
     * The name of the season (e.g., "Summer 2026").
     */
    private String name;

    /**
     * The start date of the season.
     */
    private LocalDate startDate;

    /**
     * The end date of the season.
     */
    private LocalDate endDate;

    /**
     * The price multiplier applied during the season.
     */
    private BigDecimal priceMultiplier;

    /**
     * Indicates whether the season is currently active.
     */
    private Boolean active;

    // Ensure there is a newline at the end of this file.
}
