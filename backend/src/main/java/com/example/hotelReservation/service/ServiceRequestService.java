package com.example.hotelReservation.service;

import com.example.hotelReservation.dto.ServiceRequestDto;
import com.example.hotelReservation.model.Booking;
import com.example.hotelReservation.model.ServiceRequest;
import com.example.hotelReservation.repository.BookingRepository;
import com.example.hotelReservation.repository.ServiceRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing service requests.
 * <p>
 * Provides methods for retrieving, creating, updating, and deleting service
 * requests.
 * </p>
 */
@Service
public class ServiceRequestService {

    /**
     * Repository for service request data access.
     */
    private final ServiceRequestRepository serviceRequestRepository;

    /**
     * Repository for booking data access.
     */
    private final BookingRepository bookingRepo;

    /**
     * Mapper for converting between entities and DTOs.
     */
    private final DtoMapper mapper;

    /**
     * Constructs a ServiceRequestService instance.
     *
     * @param requestRepo       the repository for service requests.
     * @param bookingRepository the repository for bookings.
     * @param dtoMapper         the mapper for converting entities and DTOs.
     */
    public ServiceRequestService(
            final ServiceRequestRepository requestRepo,
            final BookingRepository bookingRepository,
            final DtoMapper dtoMapper
    ) {
        this.serviceRequestRepository = requestRepo;
        this.bookingRepo = bookingRepository;
        this.mapper = dtoMapper;
    }

    /**
     * Creates a new service request.
     *
     * @param requestDto the DTO containing service request details.
     * @return the created ServiceRequestDto.
     */
    public ServiceRequestDto createServiceRequest(
            final ServiceRequestDto requestDto) {
        // 1) Find the booking
        Booking booking = bookingRepo.findById(requestDto.getBookingId())
                .orElseThrow(() -> new RuntimeException(
                        "Booking not found with id "
                                + requestDto.getBookingId()));

        // 2) Map DTO to entity
        ServiceRequest serviceRequest =
                mapper.toServiceRequestEntity(requestDto,
                        booking);

        // 3) Save the service request
        ServiceRequest savedServiceRequest =
                serviceRequestRepository.save(serviceRequest);

        // 4) Convert back to DTO
        return mapper.toServiceRequestDto(savedServiceRequest);
    }

    /**
     * Retrieves all service requests.
     *
     * @return a list of ServiceRequestDto.
     */
    public List<ServiceRequestDto> getAllServiceRequests() {
        return serviceRequestRepository.findAll()
                .stream()
                .map(mapper::toServiceRequestDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a service request by ID.
     *
     * @param id the ID of the service request.
     * @return the ServiceRequestDto.
     */
    public ServiceRequestDto getServiceRequestById(final Integer id) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Service request not found with id " + id));
        return mapper.toServiceRequestDto(serviceRequest);
    }

    /**
     * Updates an existing service request.
     *
     * @param id         the ID of the service request.
     * @param requestDto the updated details of the service request.
     * @return the updated ServiceRequestDto.
     */
    public ServiceRequestDto updateServiceRequest(final
                                                  Integer id,
                                                  final
                                                  ServiceRequestDto requestDto
    ) {
        ServiceRequest existingRequest = serviceRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Service request not found with id " + id));

        existingRequest.setServiceType(requestDto.getServiceType());
        existingRequest.setStatus(requestDto.getStatus());
        existingRequest.setCost(requestDto.getCost());

        ServiceRequest updatedRequest =
                serviceRequestRepository.save(existingRequest);
        return mapper.toServiceRequestDto(updatedRequest);
    }

    /**
     * Deletes a service request by ID.
     *
     * @param id the ID of the service request to delete.
     */
    public void deleteServiceRequest(final Integer id) {
        if (!serviceRequestRepository.existsById(id)) {
            throw new RuntimeException(
                    "Service request not found with id " + id);
        }
        serviceRequestRepository.deleteById(id);
    }
}
