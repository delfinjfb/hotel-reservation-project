package com.example.hotelReservation.service;

import com.example.hotelReservation.model.RoomCategory;
import com.example.hotelReservation.repository.RoomCategoryRepository;
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

    public RoomCategoryServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCategories() {
        // Create sample RoomCategory objects using Lombok's @Builder
        RoomCategory category1 = RoomCategory.builder()
                .id(1)
                .categoryName("Deluxe")
                .categoryDescription("Spacious rooms with marble bathrooms.")
                .build();

        RoomCategory category2 = RoomCategory.builder()
                .id(2)
                .categoryName("Suite")
                .categoryDescription(
                        "Luxurious suites with exceptional amenities.")
                .build();

        List<RoomCategory> categories = Arrays.asList(category1, category2);

        // Mock the repository
        when(roomCategoryRepository.findAll()).thenReturn(categories);

        // Call the service method
        List<RoomCategory> result = roomCategoryService.getAllCategories();

        // Assert the results
        assertEquals(2, result.size());
        assertEquals("Deluxe", result.get(0).getCategoryName());
        assertEquals("Suite", result.get(1).getCategoryName());
    }
}
