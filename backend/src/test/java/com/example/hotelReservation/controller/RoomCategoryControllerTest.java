package com.example.hotelReservation.controller;

import com.example.hotelReservation.model.RoomCategory;
import com.example.hotelReservation.service.RoomCategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(RoomCategoryController.class)
public class RoomCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomCategoryService roomCategoryService;

    @Test
    public void testGetAllCategories() throws Exception {
        // Create RoomCategory objects using the builder
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

        // Mock the service
        Mockito.when(roomCategoryService.getAllCategories())
                .thenReturn(categories);

        // Perform the GET request and validate the response
        mockMvc.perform(get("/api/room-categories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].categoryName").value("Deluxe"))
                .andExpect(jsonPath("$[1].categoryName").value("Suite"));
    }

    @Test
    public void testCreateCategory() throws Exception {
        RoomCategory category = RoomCategory.builder()
                .id(1)
                .categoryName("Deluxe")
                .categoryDescription("Spacious rooms with marble bathrooms.")
                .build();

        Mockito.when(roomCategoryService.createCategory(
                Mockito.any(RoomCategory.class))).thenReturn(category);

        String json = """
                {
                    "categoryName": "Deluxe",
                    "categoryDescription": "Spacious rooms with marble bathrooms."
                }
                """;

        mockMvc.perform(post("/api/room-categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoryName").value("Deluxe"))
                .andExpect(jsonPath("$.categoryDescription").value(
                        "Spacious rooms with marble bathrooms."));
    }
}
