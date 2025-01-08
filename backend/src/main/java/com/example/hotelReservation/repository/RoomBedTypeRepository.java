package com.example.hotelReservation.repository;

import com.example.hotelReservation.model.RoomBedType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomBedTypeRepository
        extends JpaRepository<RoomBedType, Long> {
}
