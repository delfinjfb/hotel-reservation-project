package com.example.hotelReservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Entry point for the Hotel Reservation application.
 *
 * <p>Initializes the Spring Boot application and configures entity scanning
 * .</p>
 */
@SpringBootApplication
@EntityScan(basePackages = "com.example.hotelReservation.model")
public final class HotelReservationApplication {

    /**
     * Main method to start the application.
     *
     * @param args the command-line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(HotelReservationApplication.class,
                args);
    }

    private HotelReservationApplication() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated");
    }
}
