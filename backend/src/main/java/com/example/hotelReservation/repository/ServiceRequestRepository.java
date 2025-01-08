package com.example.hotelReservation.repository;

import com.example.hotelReservation.model.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRequestRepository
        extends JpaRepository<ServiceRequest, Integer> {
}
