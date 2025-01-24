package com.example.hotelReservation.service;

import com.example.hotelReservation.dto.RoomCategoryWithRoomsDto;
import com.example.hotelReservation.dto.RoomCategoryWithoutRoomsDto;
import com.example.hotelReservation.model.RoomCategory;
import com.example.hotelReservation.repository.RoomCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomCategoryService {

    @Autowired
    private RoomCategoryRepository roomCategoryRepository;

    public List<RoomCategoryWithRoomsDto> getAllCategoriesWithRooms() {
        List<RoomCategory> categories = roomCategoryRepository.findAll();
        return categories.stream()
                .map(category -> new RoomCategoryWithRoomsDto(
                        category.getId(),
                        category.getCategoryName(),
                        category.getCategoryDescription(),
                        category.getRooms()))
                .collect(Collectors.toList());
    }

    public List<RoomCategoryWithoutRoomsDto> getAllCategoriesWithoutRooms() {
        List<RoomCategory> categories = roomCategoryRepository.findAll();
        return categories.stream()
                .map(category -> new RoomCategoryWithoutRoomsDto(
                        category.getId(),
                        category.getCategoryName(),
                        category.getCategoryDescription()))
                .collect(Collectors.toList());
    }

    public RoomCategory createCategory(final RoomCategory category) {
        return roomCategoryRepository.save(category);
    }
}