package com.example.hotelReservation.repository;

import com.example.hotelReservation.model.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomCategoryRepository
        extends JpaRepository<RoomCategory, Long> {
}
