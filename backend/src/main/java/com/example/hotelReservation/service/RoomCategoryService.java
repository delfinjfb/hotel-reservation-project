package com.example.hotelReservation.service;

import com.example.hotelReservation.model.RoomCategory;
import com.example.hotelReservation.repository.RoomCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for managing Room Categories.
 * <p>
 * This service provides methods to retrieve and create room categories.
 * </p>
 */
@Service
public class RoomCategoryService {

    /**
     * Repository for interacting with RoomCategory entities in the database.
     */
    @Autowired
    private RoomCategoryRepository roomCategoryRepository;

    /**
     * Retrieves all room categories.
     *
     * @return a list of {@link RoomCategory} entities.
     */
    public List<RoomCategory> getAllCategories() {
        return roomCategoryRepository.findAll();
    }

    /**
     * Creates a new room category.
     *
     * @param category the {@link RoomCategory} entity to be created.
     * @return the saved {@link RoomCategory} entity.
     */
    public RoomCategory createCategory(final RoomCategory category) {
        return roomCategoryRepository.save(category);
    }
}
