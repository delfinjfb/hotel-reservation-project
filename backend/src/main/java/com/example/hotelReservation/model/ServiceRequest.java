package com.example.hotelReservation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a service request in the Hotel Reservation system.
 *
 * <p>Each service request is associated with a booking and includes
 * details such as type, status, and cost.</p>
 */
@Entity
@Table(name = "services")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class ServiceRequest {

    /**
     * The unique identifier for the service request.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The type of service requested (e.g., "Room Service", "Laundry").
     */
    @Column(name = "service_type", nullable = false)
    private String serviceType;

    /**
     * The status of the service request (e.g., "Pending", "Completed").
     */
    @Column(name = "status", nullable = false)
    private String status;

    /**
     * The cost of the service request.
     */
    @Column(name = "cost", nullable = false, precision = COST_PRECISION,
            scale = COST_SCALE)
    private BigDecimal cost;

    /**
     * The timestamp when the service request was created.
     */
    @Column(name = "created_at", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    /**
     * The timestamp when the service request was last updated.
     */
    @Column(name = "updated_at",
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    /**
     * Sets the createdAt field to the current timestamp before persisting.
     */
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Sets the updatedAt field to the current timestamp before updating.
     */
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Precision for the cost field.
     */
    public static final int COST_PRECISION = 10;

    /**
     * Scale for the cost field.
     */
    public static final int COST_SCALE = 2;
}
