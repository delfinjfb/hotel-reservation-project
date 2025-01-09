package com.example.hotelReservation.exception;

/**
 * Custom exception for validation errors.
 *
 * <p>This exception is thrown when validation fails in the application.</p>
 */
public class ValidationException extends RuntimeException {

    /**
     * Constructs a new ValidationException with the specified detail message.
     *
     * @param message the detail message, providing information about the
     *                validation error
     */
    public ValidationException(final String message) {
        super(message);
    }
}
