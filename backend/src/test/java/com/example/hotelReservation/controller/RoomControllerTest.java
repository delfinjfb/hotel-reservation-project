package com.example.hotelReservation.controller;

import com.example.hotelReservation.dto.RoomDto;
import com.example.hotelReservation.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;

public class RoomControllerTest {

    @Mock
    private RoomService roomService;

    @InjectMocks
    private RoomController roomController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRooms() {
        RoomDto roomDto = RoomDto.builder()
                .id(1)
                .roomDescription("Calm and luminous room.")
                .roomSize(20)
                .roomType("Chambre Première")
                .roomMaxPersons(2)
                .roomNumber("101")
                .basePrice(BigDecimal.valueOf(120.50))
                //.categoryName("Chambre Première") // Ensure this is set
                .build();

        when(roomService.getAllRooms()).thenReturn(List.of(roomDto));

        // Add assertions and test logic for the controller.
    }
}
