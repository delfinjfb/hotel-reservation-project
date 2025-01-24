package com.example.hotelReservation.controller;

import com.example.hotelReservation.dto.RoomCategoryWithRoomsDto;
import com.example.hotelReservation.dto.RoomCategoryWithoutRoomsDto;
import com.example.hotelReservation.service.RoomCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RoomCategoryControllerTest {

    @Mock
    private RoomCategoryService roomCategoryService;

    @InjectMocks
    private RoomCategoryController roomCategoryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCategoriesWithRooms() {
        List<RoomCategoryWithRoomsDto> categories = Arrays.asList(
                new RoomCategoryWithRoomsDto(1, "Category1", "Description1", null),
                new RoomCategoryWithRoomsDto(2, "Category2", "Description2", null)
        );

        when(roomCategoryService.getAllCategoriesWithRooms()).thenReturn(categories);

        ResponseEntity<List<RoomCategoryWithRoomsDto>> response = roomCategoryController.getAllCategoriesWithRooms();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(categories, response.getBody());
    }

    @Test
    public void testGetAllCategoriesWithoutRooms() {
        List<RoomCategoryWithoutRoomsDto> categories = Arrays.asList(
                new RoomCategoryWithoutRoomsDto(1, "Category1", "Description1"),
                new RoomCategoryWithoutRoomsDto(2, "Category2", "Description2")
        );

        when(roomCategoryService.getAllCategoriesWithoutRooms()).thenReturn(categories);

        ResponseEntity<List<RoomCategoryWithoutRoomsDto>> response = roomCategoryController.getAllCategoriesWithoutRooms();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(categories, response.getBody());
    }
}