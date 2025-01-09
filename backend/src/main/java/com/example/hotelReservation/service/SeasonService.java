package com.example.hotelReservation.service;

import com.example.hotelReservation.dto.SeasonDto;
import com.example.hotelReservation.model.Season;
import com.example.hotelReservation.repository.SeasonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer for managing Seasons.
 * <p>
 * Provides methods for retrieving, creating, updating, and deleting seasons.
 * </p>
 */
@Service
public final class SeasonService {

    /**
     * Repository for Season entities.
     */
    private final SeasonRepository seasonRepository;

    /**
     * Mapper for converting entities to DTOs and vice versa.
     */
    private final DtoMapper dtoMapper;

    /**
     * Constructor for SeasonService.
     *
     * @param repository the {@link SeasonRepository} for interacting
     *                   with the database.
     * @param mapper     the {@link DtoMapper} for converting between
     *                   entities and DTOs.
     */
    public SeasonService(final SeasonRepository repository,
                         final DtoMapper mapper) {
        this.seasonRepository = repository;
        this.dtoMapper = mapper;
    }

    /**
     * Retrieves all seasons.
     *
     * @return a list of {@link SeasonDto}.
     */
    public List<SeasonDto> getAllSeasons() {
        return seasonRepository.findAll()
                .stream()
                .map(dtoMapper::toSeasonDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a season by its ID.
     *
     * @param id the ID of the season to retrieve.
     * @return the corresponding {@link SeasonDto}.
     */
    public SeasonDto getSeasonById(final Integer id) {
        Season season = seasonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Season not found with id " + id));
        return dtoMapper.toSeasonDto(season);
    }

    /**
     * Creates a new season.
     *
     * @param seasonDto the {@link SeasonDto} containing season details.
     * @return the saved {@link SeasonDto}.
     */
    public SeasonDto createSeason(final SeasonDto seasonDto) {
        Season season = dtoMapper.toSeasonEntity(seasonDto);
        Season savedSeason = seasonRepository.save(season);
        return dtoMapper.toSeasonDto(savedSeason);
    }

    /**
     * Updates an existing season.
     *
     * @param id        the ID of the season to update.
     * @param seasonDto the {@link SeasonDto} containing updated details.
     * @return the updated {@link SeasonDto}.
     */
    public SeasonDto updateSeason(final Integer id, final SeasonDto seasonDto) {
        Season existingSeason = seasonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Season not found with id " + id));

        existingSeason.setName(seasonDto.getName());
        existingSeason.setStartDate(seasonDto.getStartDate());
        existingSeason.setEndDate(seasonDto.getEndDate());
        existingSeason.setPriceMultiplier(seasonDto.getPriceMultiplier());
        existingSeason.setActive(Boolean.TRUE.equals(seasonDto.getActive()));

        Season updatedSeason = seasonRepository.save(existingSeason);
        return dtoMapper.toSeasonDto(updatedSeason);
    }

    /**
     * Deletes a season by its ID.
     *
     * @param id the ID of the season to delete.
     */
    public void deleteSeason(final Integer id) {
        if (!seasonRepository.existsById(id)) {
            throw new RuntimeException("Season not found with id " + id);
        }
        seasonRepository.deleteById(id);
    }
}
