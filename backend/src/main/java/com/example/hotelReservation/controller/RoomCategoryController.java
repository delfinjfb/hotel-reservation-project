package com.example.hotelReservation.controller;

import com.example.hotelReservation.dto.RoomCategoryWithRoomsDto;
import com.example.hotelReservation.dto.RoomCategoryWithoutRoomsDto;
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

@RestController
@RequestMapping("/api/room-categories")
public final class RoomCategoryController {

    private final RoomCategoryService roomCategoryService;

    @Autowired
    public RoomCategoryController(final RoomCategoryService service) {
        this.roomCategoryService = service;
    }

    @GetMapping("/with-rooms")
    public ResponseEntity<List<RoomCategoryWithRoomsDto>> getAllCategoriesWithRooms() {
        return ResponseEntity.ok(roomCategoryService.getAllCategoriesWithRooms());
    }

    @GetMapping("/without-rooms")
    public ResponseEntity<List<RoomCategoryWithoutRoomsDto>> getAllCategoriesWithoutRooms() {
        return ResponseEntity.ok(roomCategoryService.getAllCategoriesWithoutRooms());
    }

    @PostMapping
    public ResponseEntity<RoomCategory> createCategory(
            @RequestBody final RoomCategory category) {
        return ResponseEntity.ok(roomCategoryService.createCategory(category));
    }
}
