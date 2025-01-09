package com.example.hotelReservation.controller;

import com.example.hotelReservation.dto.RoomCategoryProjection;
import com.example.hotelReservation.dto.RoomDto;
import com.example.hotelReservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * Controller for handling room-related operations.
 */
@RestController
@RequestMapping("/api/rooms")
public final class RoomController {

    /**
     * Service for managing room operations.
     */
    private final RoomService roomService;

    /**
     * Constructs a new RoomController with the given service.
     *
     * @param service the service to handle room-related logic
     */
    @Autowired
    public RoomController(final RoomService service) {
        this.roomService = service;
    }

    /**
     * Retrieves all rooms.
     *
     * @return a list of all {@link RoomDto} objects
     */
    @GetMapping
    public List<RoomDto> getAllRooms() {
        return roomService.getAllRooms();
    }

    /**
     * Retrieves a room by its ID.
     *
     * @param id the ID of the room
     * @return the {@link RoomDto} for the specified ID
     */
    @GetMapping("/{id}")
    public RoomDto getRoomById(@PathVariable final Integer id) {
        return roomService.getRoomById(id);
    }

    /**
     * Creates a new room.
     *
     * @param roomDto the room details to create
     * @return the created {@link RoomDto}
     */
    @PostMapping
    public RoomDto createRoom(@RequestBody final RoomDto roomDto) {
        return roomService.createRoom(roomDto);
    }

    /**
     * Updates an existing room.
     *
     * @param id      the ID of the room to update
     * @param roomDto the updated room details
     * @return the updated {@link RoomDto}
     */
    @PutMapping("/{id}")
    public RoomDto updateRoom(@PathVariable final Integer id,
                              @RequestBody final RoomDto roomDto) {
        return roomService.updateRoom(id, roomDto);
    }

    /**
     * Deletes a room by its ID.
     *
     * @param id the ID of the room to delete
     */
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable final Integer id) {
        roomService.deleteRoom(id);
    }

    /**
     * Retrieves available rooms within the specified date range.
     *
     * @param startDate the start date for availability search
     * @param endDate   the end date for availability search
     * @return a response containing a list of available room categories
     */
    @GetMapping("/available-rooms")
    public ResponseEntity<List<RoomCategoryProjection>> getAvailableRooms(
            @RequestParam("startDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            final LocalDate startDate,
            @RequestParam("endDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            final LocalDate endDate) {
        List<RoomCategoryProjection> availableRooms =
                roomService.getAvailableRooms(startDate, endDate);
        return ResponseEntity.ok(availableRooms);
    }
}
