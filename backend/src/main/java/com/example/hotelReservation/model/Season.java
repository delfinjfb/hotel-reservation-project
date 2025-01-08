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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Represents a season in the Hotel Reservation system.
 *
 * <p>Each season has a name, a date range, a price multiplier, and an active
 * status.</p>
 */
@Entity
@Table(name = "seasons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public final class Season {

    /**
     * The unique identifier for the season.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The name of the season.
     */
    @Column(name = "name", nullable = false, length = NAME_MAX_LENGTH)
    private String name;

    /**
     * The start date of the season.
     */
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    /**
     * The end date of the season.
     */
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    /**
     * The price multiplier applied during the season.
     */
    @Column(name = "price_multiplier", nullable = false)
    private BigDecimal priceMultiplier;

    /**
     * Indicates whether the season is currently active.
     */
    @Column(name = "active", nullable = false)
    private boolean active;

    /**
     * Returns the active status of the season.
     *
     * @return true if the season is active, false otherwise.
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Sets the active status of the season.
     *
     * @param isActive the new active status.
     */
    public void setActive(final Boolean isActive) {
        this.active = isActive;
    }

    /**
     * The timestamp when the season record was created.
     */
    @Column(name = "created_at", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    /**
     * The timestamp when the season record was last updated.
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
     * Maximum length for the season name.
     */
    public static final int NAME_MAX_LENGTH = 50;
}
