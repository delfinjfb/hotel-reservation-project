package com.example.hotelReservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the application.
 *
 * <p>Handles various types of exceptions and returns appropriate
 * HTTP responses.</p>
 */
@ControllerAdvice
public final class GlobalExceptionHandler {

    /**
     * Handles {@link ValidationException}.
     *
     * @param ex the exception to handle
     * @return a response entity with status 400 and the exception message
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(
            final ValidationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    /**
     * Handles {@link RuntimeException}.
     *
     * @param ex the exception to handle
     * @return a response entity with status 500 and a generic error message
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(
            final RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }

    /**
     * Handles generic {@link Exception}.
     *
     * @param ex the exception to handle
     * @return a response entity with status 500 and a generic error message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(final Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + ex.getMessage());
    }
}
