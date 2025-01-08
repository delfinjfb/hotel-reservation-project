package com.example.hotelReservation.controller;

import com.example.hotelReservation.dto.ServiceRequestDto;
import com.example.hotelReservation.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Controller for handling service request operations.
 */
@RestController
@RequestMapping("/api/services")
public final class ServiceRequestController {

    /**
     * Service for managing service requests.
     */
    private final ServiceRequestService serviceRequestService;

    /**
     * Constructs a new ServiceRequestController.
     *
     * @param service the service for managing service requests
     */
    @Autowired
    public ServiceRequestController(final ServiceRequestService service) {
        this.serviceRequestService = service;
    }

    /**
     * Retrieves all service requests.
     *
     * @return a list of {@link ServiceRequestDto} objects
     */
    @GetMapping
    public List<ServiceRequestDto> getAllServiceRequests() {
        return serviceRequestService.getAllServiceRequests();
    }

    /**
     * Retrieves a service request by its ID.
     *
     * @param id the ID of the service request
     * @return the {@link ServiceRequestDto} for the specified ID
     */
    @GetMapping("/{id}")
    public ServiceRequestDto getServiceRequest(@PathVariable final Integer id) {
        return serviceRequestService.getServiceRequestById(id);
    }

    /**
     * Creates a new service request.
     *
     * @param dto the service request details to create
     * @return the created {@link ServiceRequestDto}
     */
    @PostMapping
    public ServiceRequestDto createServiceRequest(
            @RequestBody final ServiceRequestDto dto) {
        return serviceRequestService.createServiceRequest(dto);
    }

    /**
     * Updates an existing service request.
     *
     * @param id  the ID of the service request to update
     * @param dto the updated service request details
     * @return the updated {@link ServiceRequestDto}
     */
    @PutMapping("/{id}")
    public ServiceRequestDto updateServiceRequest(
            @PathVariable final Integer id,
            @RequestBody final ServiceRequestDto dto) {
        return serviceRequestService.updateServiceRequest(id, dto);
    }

    /**
     * Deletes a service request by its ID.
     *
     * @param id the ID of the service request to delete
     */
    @DeleteMapping("/{id}")
    public void deleteServiceRequest(@PathVariable final Integer id) {
        serviceRequestService.deleteServiceRequest(id);
    }
}
