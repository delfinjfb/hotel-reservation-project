package com.example.hotelReservation.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a category of rooms in the Hotel Reservation system.
 *
 * <p>Each category defines the type, features, and description of rooms.</p>
 */
@Entity
@Table(name = "room_categories")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class RoomCategory {

    /**
     * The unique identifier for the room category.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The name of the category.
     */
    @Column(name = "category_name", nullable = false,
            length = CATEGORY_NAME_MAX_LENGTH)
    private String categoryName;

    /**
     * A detailed description of the category.
     */
    @Column(name = "category_description", nullable = false,
            columnDefinition = "TEXT")
    private String categoryDescription;

    /**
     * A list of rooms that belong to this category.
     */
    @OneToMany(mappedBy = "roomCategory", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Room> rooms;

    /**
     * The timestamp when the category record was created.
     */
    @Column(name = "created_at", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    /**
     * The timestamp when the category record was last updated.
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
     * Maximum length for the category name.
     */
    public static final int CATEGORY_NAME_MAX_LENGTH = 100;
}
