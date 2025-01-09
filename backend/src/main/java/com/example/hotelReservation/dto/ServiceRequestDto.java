package com.example.hotelReservation.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Data Transfer Object for service requests.
 *
 * <p>Holds information about a service request, including its ID,
 * associated booking, service type, status, and cost.</p>
 */
@Data
@Builder
public class ServiceRequestDto {

    /**
     * The unique identifier of the service request.
     */
    private Integer id;

    /**
     * The ID of the booking associated with the service request.
     *
     * <p>This is used to fetch the related booking details.</p>
     */
    private Integer bookingId;

    /**
     * The type of service requested (e.g., "Dining", "Spa").
     */
    private String serviceType;

    /**
     * The status of the service request (e.g., "Pending", "Completed").
     */
    private String status;

    /**
     * The cost of the service request.
     */
    private BigDecimal cost;

    // Ensure there is a newline at the end of the file.
}
