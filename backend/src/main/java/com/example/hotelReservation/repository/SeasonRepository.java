package com.example.hotelReservation.repository;

import com.example.hotelReservation.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Season entity.
 */
@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {

    /**
     * Finds all active seasons.
     *
     * @return a list of active seasons
     */
    List<Season> findByActiveTrue();
}
