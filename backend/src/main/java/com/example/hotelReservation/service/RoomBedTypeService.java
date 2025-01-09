package com.example.hotelReservation.service;

import com.example.hotelReservation.model.RoomBedType;
import com.example.hotelReservation.repository.RoomBedTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for managing Room Bed Types.
 * <p>
 * This service provides methods to retrieve and create bed types for rooms.
 * </p>
 */
@Service
public class RoomBedTypeService {

    /**
     * Repository for interacting with RoomBedType entities in the database.
     */
    @Autowired
    private RoomBedTypeRepository roomBedTypeRepository;

    /**
     * Retrieves all bed types associated with a specific room.
     *
     * @param roomId the ID of the room whose bed types are to be retrieved.
     * @return a list of {@link RoomBedType} associated with the room.
     */
    public List<RoomBedType> getAllBedTypesForRoom(final Long roomId) {
        return roomBedTypeRepository.findAll()
                .stream()
                // Uncomment the filter below when Room relationship is added
                // .filter(bedType -> bedType.getRoom().getId().equals(roomId))
                .toList();
    }

    /**
     * Creates a new bed type and associates it with a room.
     *
     * @param roomBedType the {@link RoomBedType} entity to be created.
     * @return the saved {@link RoomBedType} entity.
     */
    public RoomBedType createBedType(final RoomBedType roomBedType) {
        return roomBedTypeRepository.save(roomBedType);
    }
}
