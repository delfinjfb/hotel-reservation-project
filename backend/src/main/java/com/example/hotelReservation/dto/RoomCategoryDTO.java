package com.example.hotelReservation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomCategoryDTO {
    private Integer id;
    private String categoryName;
    private String categoryDescription;
}
