package com.example.hotelReservation.dto;

import com.example.hotelReservation.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomCategoryWithRoomsDto {
    private Integer id;
    private String categoryName;
    private String categoryDescription;
    private List<Room> rooms;
}