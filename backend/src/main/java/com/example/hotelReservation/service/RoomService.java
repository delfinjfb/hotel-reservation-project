package com.example.hotelReservation.service;

import com.example.hotelReservation.dto.RoomCategoryProjection;
import com.example.hotelReservation.dto.RoomDto;
import com.example.hotelReservation.model.Room;
import com.example.hotelReservation.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer for managing Room entities.
 * <p>
 * Provides methods for retrieving, creating, updating, and deleting rooms.
 * </p>
 */
@Service
public final class RoomService {

    /**
     * Repository for Room entities.
     */
    private final RoomRepository roomRepository;

    /**
     * Mapper for converting entities to DTOs and vice versa.
     */
    private final DtoMapper roomDtoMapper;

    /**
     * Constructor for RoomService.
     *
     * @param repository the {@link RoomRepository} to interact with the
     *                   database.
     * @param dtoMapper  the {@link DtoMapper} to convert between entities
     *                   and DTOs.
     */
    public RoomService(final RoomRepository repository,
                       final DtoMapper dtoMapper) {
        this.roomRepository = repository;
        this.roomDtoMapper = dtoMapper;
    }

    /**
     * Retrieves all rooms.
     *
     * @return a list of {@link RoomDto}.
     */
    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(roomDtoMapper::toRoomDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a room by its ID.
     *
     * @param id the ID of the room to retrieve.
     * @return the corresponding {@link RoomDto}.
     */
    public RoomDto getRoomById(final Integer id) {
        return roomRepository.findById(id)
                .map(roomDtoMapper::toRoomDto)
                .orElseThrow(() -> new RuntimeException("Room not found with "
                        + "id "
                        + id));
    }

    /**
     * Creates a new room.
     *
     * @param roomDto the {@link RoomDto} to create.
     * @return the saved {@link RoomDto}.
     */
    public RoomDto createRoom(final RoomDto roomDto) {
        Room roomEntity = roomDtoMapper.toRoomEntity(roomDto);
        Room savedRoom = roomRepository.save(roomEntity);
        return roomDtoMapper.toRoomDto(savedRoom);
    }

    /**
     * Updates an existing room.
     *
     * @param id      the ID of the room to update.
     * @param roomDto the {@link RoomDto} with updated details.
     * @return the updated {@link RoomDto}.
     */
    public RoomDto updateRoom(final Integer id,
                              final RoomDto roomDto) {
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Room not found with id "
                                + id));

        existingRoom.setRoomNumber(roomDto.getRoomNumber());
        existingRoom.setRoomType(roomDto.getRoomType());

        if (roomDto.getBasePrice()
                != null) {
            existingRoom.setBasePrice(roomDto.getBasePrice());
        }

        Room updatedRoom = roomRepository.save(existingRoom);
        return roomDtoMapper.toRoomDto(updatedRoom);
    }

    /**
     * Deletes a room by its ID.
     *
     * @param id the ID of the room to delete.
     */
    public void deleteRoom(final Integer id) {
        if (!roomRepository.existsById(id)) {
            throw new RuntimeException("Room not found with id "
                    + id);
        }
        roomRepository.deleteById(id);
    }

    /**
     * Retrieves available rooms within a date range.
     *
     * @param startDate the start date of the range.
     * @param endDate   the end date of the range.
     * @return a list of {@link RoomCategoryProjection}.
     */
    public List<RoomCategoryProjection> getAvailableRooms(
            final LocalDate startDate,
            final LocalDate endDate) {
        return roomRepository.findAvailableRoomProjections(startDate,
                endDate);
    }
}
