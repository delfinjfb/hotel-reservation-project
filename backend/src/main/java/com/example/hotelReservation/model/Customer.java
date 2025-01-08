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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Represents a customer in the Hotel Reservation system.
 */
@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Customer {

    /**
     * The unique identifier for the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The name of the customer.
     */
    @Column(nullable = false, length = NAME_MAX_LENGTH)
    private String name;

    /**
     * The email address of the customer.
     */
    @Column(nullable = false, length = EMAIL_MAX_LENGTH, unique = true)
    private String email;

    /**
     * The phone number of the customer.
     */
    @Column(name = "phone_number", length = PHONE_NUMBER_MAX_LENGTH)
    private String phoneNumber;

    /**
     * The timestamp when the customer record was created.
     */
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * The timestamp when the customer record was last updated.
     */
    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    /**
     * Maximum length for the customer's name.
     */
    public static final int NAME_MAX_LENGTH = 100;

    /**
     * Maximum length for the customer's email address.
     */
    public static final int EMAIL_MAX_LENGTH = 100;

    /**
     * Maximum length for the customer's phone number.
     */
    public static final int PHONE_NUMBER_MAX_LENGTH = 15;
}
