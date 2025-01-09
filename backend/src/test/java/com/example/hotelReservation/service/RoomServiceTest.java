package com.example.hotelReservation.service;

import com.example.hotelReservation.dto.RoomDto;
import com.example.hotelReservation.model.Room;
import com.example.hotelReservation.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private DtoMapper dtoMapper;

    @InjectMocks
    private RoomService roomService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRooms() {
        // Mock Room entities
        Room room1 = Room.builder()
                .id(1)
                .roomDescription("Calm and luminous room with a double bed.")
                .roomSize(20)
                .roomType("Chambre Première")
                .roomMaxPersons(2)
                .roomNumber("101")
                .basePrice(BigDecimal.valueOf(120.50))
                .build();

        Room room2 = Room.builder()
                .id(2)
                .roomDescription("Spacious room with modern amenities.")
                .roomSize(25)
                .roomType("Chambre Deluxe")
                .roomMaxPersons(2)
                .roomNumber("102")
                .basePrice(BigDecimal.valueOf(150.00))
                .build();

        List<Room> mockRooms = Arrays.asList(room1, room2);

        // Mock DTO conversion
        RoomDto dto1 = RoomDto.builder()
                .id(1)
                .roomDescription("Calm and luminous room with a double bed.")
                .roomSize(20)
                .roomType("Chambre Première")
                .roomMaxPersons(2)
                .roomNumber("101")
                .basePrice(BigDecimal.valueOf(120.50))
                .build();

        RoomDto dto2 = RoomDto.builder()
                .id(2)
                .roomDescription("Spacious room with modern amenities.")
                .roomSize(25)
                .roomType("Chambre Deluxe")
                .roomMaxPersons(2)
                .roomNumber("102")
                .basePrice(BigDecimal.valueOf(150.00))
                .build();

        List<RoomDto> mockRoomDtos = Arrays.asList(dto1, dto2);

        // Mock repository behavior
        when(roomRepository.findAll()).thenReturn(mockRooms);
        when(dtoMapper.toRoomDto(room1)).thenReturn(dto1);
        when(dtoMapper.toRoomDto(room2)).thenReturn(dto2);

        // Test service method
        List<RoomDto> result = roomService.getAllRooms();

        // Assertions
        assertEquals(2, result.size());
        assertEquals("Calm and luminous room with a double bed.",
                result.get(0).getRoomDescription());
        assertEquals("Spacious room with modern amenities.",
                result.get(1).getRoomDescription());
    }
}
