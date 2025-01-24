package com.example.hotelReservation.service;

import com.example.hotelReservation.dto.RoomCategoryWithRoomsDto;
import com.example.hotelReservation.dto.RoomCategoryWithoutRoomsDto;
import com.example.hotelReservation.model.RoomCategory;
import com.example.hotelReservation.repository.RoomCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RoomCategoryServiceTest {

    @Mock
    private RoomCategoryRepository roomCategoryRepository;

    @InjectMocks
    private RoomCategoryService roomCategoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCategoriesWithRooms() {
        List<RoomCategory> categories = Arrays.asList(
                new RoomCategory(1, "Category1", "Description1", null, null, null),
                new RoomCategory(2, "Category2", "Description2", null, null, null)
        );

        when(roomCategoryRepository.findAll()).thenReturn(categories);

        List<RoomCategoryWithRoomsDto> expected = Arrays.asList(
                new RoomCategoryWithRoomsDto(1, "Category1", "Description1", null),
                new RoomCategoryWithRoomsDto(2, "Category2", "Description2", null)
        );

        List<RoomCategoryWithRoomsDto> result = roomCategoryService.getAllCategoriesWithRooms();
        assertEquals(expected, result);
    }

    @Test
    public void testGetAllCategoriesWithoutRooms() {
        List<RoomCategory> categories = Arrays.asList(
                new RoomCategory(1, "Category1", "Description1", null, null, null),
                new RoomCategory(2, "Category2", "Description2", null, null, null)
        );

        when(roomCategoryRepository.findAll()).thenReturn(categories);

        List<RoomCategoryWithoutRoomsDto> expected = Arrays.asList(
                new RoomCategoryWithoutRoomsDto(1, "Category1", "Description1"),
                new RoomCategoryWithoutRoomsDto(2, "Category2", "Description2")
        );

        List<RoomCategoryWithoutRoomsDto> result = roomCategoryService.getAllCategoriesWithoutRooms();
        assertEquals(expected, result);
    }
}