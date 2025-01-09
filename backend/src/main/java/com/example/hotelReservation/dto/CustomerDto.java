package com.example.hotelReservation.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Data Transfer Object for customer details.
 *
 * <p>Holds information about a customer, including their ID, name, email,
 * and phone number.</p>
 */
@Data
@Builder
public class CustomerDto {

    /**
     * The unique identifier of the customer.
     */
    private Integer id;

    /**
     * The name of the customer.
     */
    private String name;

    /**
     * The email address of the customer.
     */
    private String email;

    /**
     * The phone number of the customer.
     */
    private String phoneNumber;
}
