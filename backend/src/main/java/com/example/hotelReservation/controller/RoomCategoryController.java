package com.example.hotelReservation.controller;

import com.example.hotelReservation.model.RoomCategory;
import com.example.hotelReservation.service.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for handling room category-related requests.
 */
@RestController
@RequestMapping("/api/room-categories")
public final class RoomCategoryController {

    /**
     * Service for managing room categories.
     */
    private final RoomCategoryService roomCategoryService;

    /**
     * Constructs a new RoomCategoryController with the given service.
     *
     * @param service the service for handling room category operations
     */
    @Autowired
    public RoomCategoryController(final RoomCategoryService service) {
        this.roomCategoryService = service;
    }

    /**
     * Retrieves all room categories.
     *
     * @return a response containing a list of room categories
     */
    @GetMapping
    public ResponseEntity<List<RoomCategory>> getAllCategories() {
        return ResponseEntity.ok(roomCategoryService.getAllCategories());
    }

    /**
     * Creates a new room category.
     *
     * @param category the room category to create
     * @return a response containing the created room category
     */
    @PostMapping
    public ResponseEntity<RoomCategory> createCategory(
            @RequestBody final RoomCategory category) {
        return ResponseEntity.ok(roomCategoryService.createCategory(category));
    }
}
