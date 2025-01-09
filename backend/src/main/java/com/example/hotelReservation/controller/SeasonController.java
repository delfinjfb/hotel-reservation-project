package com.example.hotelReservation.controller;

import com.example.hotelReservation.dto.SeasonDto;
import com.example.hotelReservation.service.SeasonService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for handling season-related operations.
 */
@RestController
@RequestMapping("/api/seasons")
public final class SeasonController {

    /**
     * Service for managing season operations.
     */
    private final SeasonService seasonService;

    /**
     * Constructs a new SeasonController with the specified service.
     *
     * @param service the service for handling season-related logic
     */
    public SeasonController(final SeasonService service) {
        this.seasonService = service;
    }

    /**
     * Retrieves all seasons.
     *
     * @return a list of all {@link SeasonDto} objects
     */
    @GetMapping
    public List<SeasonDto> getAllSeasons() {
        return seasonService.getAllSeasons();
    }

    /**
     * Retrieves a season by its ID.
     *
     * @param id the ID of the season
     * @return the {@link SeasonDto} for the specified ID
     */
    @GetMapping("/{id}")
    public SeasonDto getSeasonById(@PathVariable final Integer id) {
        return seasonService.getSeasonById(id);
    }

    /**
     * Creates a new season.
     *
     * @param dto the season details to create
     * @return the created {@link SeasonDto}
     */
    @PostMapping
    public SeasonDto createSeason(@RequestBody final SeasonDto dto) {
        return seasonService.createSeason(dto);
    }

    /**
     * Updates an existing season.
     *
     * @param id  the ID of the season to update
     * @param dto the updated season details
     * @return the updated {@link SeasonDto}
     */
    @PutMapping("/{id}")
    public SeasonDto updateSeason(@PathVariable final Integer id,
                                  @RequestBody final SeasonDto dto) {
        return seasonService.updateSeason(id, dto);
    }

    /**
     * Deletes a season by its ID.
     *
     * @param id the ID of the season to delete
     */
    @DeleteMapping("/{id}")
    public void deleteSeason(@PathVariable final Integer id) {
        seasonService.deleteSeason(id);
    }
}
