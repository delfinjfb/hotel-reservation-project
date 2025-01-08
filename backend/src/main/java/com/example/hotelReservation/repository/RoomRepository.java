package com.example.hotelReservation.repository;

import com.example.hotelReservation.dto.RoomCategoryProjection;
import com.example.hotelReservation.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Room entity.
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    /**
     * Finds available room projections for the given date range.
     *
     * @param startDate the start date of the desired booking period
     * @param endDate   the end date of the desired booking period
     * @return a list of projections representing available room categories
     */
    @Query("""
                SELECT r.roomType AS category, r.basePrice AS price,
                COUNT(r.id) AS count
                FROM Room r WHERE r.id NOT IN (
                    SELECT b.room.id FROM Booking b
                    WHERE b.startDate <= :endDate AND b.endDate >= :startDate
                )
                GROUP BY r.roomType, r.basePrice
                ORDER BY r.roomType, r.basePrice
            """)
    List<RoomCategoryProjection> findAvailableRoomProjections(
            @Param("startDate")
            LocalDate startDate,
            @Param("endDate")
            LocalDate endDate
    );
}
