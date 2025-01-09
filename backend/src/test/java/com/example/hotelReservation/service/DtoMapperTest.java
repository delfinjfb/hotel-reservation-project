package com.example.hotelReservation.service;

import com.example.hotelReservation.dto.RoomDto;
import com.example.hotelReservation.model.Room;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DtoMapperTest {

    private final DtoMapper dtoMapper = new DtoMapper();

    @Test
    public void testRoomToRoomDtoMapping() {
        Room room = Room.builder()
                .id(1)
                .roomNumber("101")
                .roomDescription("A spacious deluxe room")
                .roomSize(25)
                .roomType("Deluxe")
                .roomMaxPersons(2)
                .basePrice(BigDecimal.valueOf(200.00))
                .build();

        RoomDto roomDto = dtoMapper.toRoomDto(room);

        assertEquals(room.getId(), roomDto.getId());
        assertEquals(room.getRoomNumber(), roomDto.getRoomNumber());
        assertEquals(room.getRoomDescription(), roomDto.getRoomDescription());
        assertEquals(room.getRoomSize(), roomDto.getRoomSize());
        assertEquals(room.getRoomType(), roomDto.getRoomType());
        assertEquals(room.getRoomMaxPersons(), roomDto.getRoomMaxPersons());
        assertEquals(room.getBasePrice(), roomDto.getBasePrice());
    }

    @Test
    public void testRoomDtoToRoomMapping() {
        RoomDto roomDto = RoomDto.builder()
                .id(1)
                .roomNumber("101")
                .roomDescription("A spacious deluxe room")
                .roomSize(25)
                .roomType("Deluxe")
                .roomMaxPersons(2)
                .basePrice(BigDecimal.valueOf(200.00))
                .build();

        Room room = dtoMapper.toRoomEntity(roomDto);

        assertEquals(roomDto.getId(), room.getId());
        assertEquals(roomDto.getRoomNumber(), room.getRoomNumber());
        assertEquals(roomDto.getRoomDescription(), room.getRoomDescription());
        assertEquals(roomDto.getRoomSize(), room.getRoomSize());
        assertEquals(roomDto.getRoomType(), room.getRoomType());
        assertEquals(roomDto.getRoomMaxPersons(), room.getRoomMaxPersons());
        assertEquals(roomDto.getBasePrice(), room.getBasePrice());
    }
}
