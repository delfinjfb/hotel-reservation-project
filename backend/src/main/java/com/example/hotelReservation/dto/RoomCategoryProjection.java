package com.example.hotelReservation.dto;

import java.math.BigDecimal;

/**
 * Projection interface for room category data.
 *
 * <p>Used to represent aggregated data for room categories, including
 * category name, price, and count.</p>
 */
public interface RoomCategoryProjection {

    /**
     * Gets the name of the room category.
     *
     * @return the category name
     */
    String getCategory();

    /**
     * Gets the price associated with the room category.
     *
     * @return the price as a {@link BigDecimal}
     */
    BigDecimal getPrice();

    /**
     * Gets the count of available rooms in this category.
     *
     * @return the count of rooms
     */
    Long getCount();
}
