package com.example.hotelReservation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomCategoryWithoutRoomsDto {
    private Integer id;
    private String categoryName;
    private String categoryDescription;
}