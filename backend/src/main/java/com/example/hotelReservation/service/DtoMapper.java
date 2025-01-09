package com.example.hotelReservation.service;

import com.example.hotelReservation.dto.BookingDto;
import com.example.hotelReservation.dto.CustomerDto;
import com.example.hotelReservation.dto.RoomDto;
import com.example.hotelReservation.dto.SeasonDto;
import com.example.hotelReservation.dto.ServiceRequestDto;
import com.example.hotelReservation.model.Booking;
import com.example.hotelReservation.model.Customer;
import com.example.hotelReservation.model.Room;
import com.example.hotelReservation.model.Season;
import com.example.hotelReservation.model.ServiceRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Utility class for mapping between DTOs and Entities in the Hotel
 * Reservation system.
 */
@Component
public final class DtoMapper {

    /**
     * Converts a Booking entity to a BookingDto.
     *
     * @param booking the Booking entity
     * @return the BookingDto
     */
    public BookingDto toBookingDto(final Booking booking) {
        if (booking
                == null) {
            return null;
        }
        return BookingDto.builder()
                .id(booking.getId())
                .roomId(booking.getRoom()
                        != null
                        ?
                        booking.getRoom().getId()
                        :
                        null)
                .customerId(booking.getCustomerId())
                .startDate(booking.getStartDate())
                .endDate(booking.getEndDate())
                .totalPrice(booking.getTotalPrice()
                        != null
                        ?
                        booking.getTotalPrice().doubleValue()
                        :
                        null)
                .status(booking.getStatus())
                .appliedSeasonId(booking.getAppliedSeasonId())
                .appliedMultiplier(booking.getAppliedMultiplier()
                        != null
                        ?
                        booking.getAppliedMultiplier().doubleValue()
                        :
                        null)
                .appliedSeasonName(booking.getAppliedSeasonName())
                .build();
    }

    /**
     * Converts a BookingDto to a Booking entity.
     *
     * @param bookingDto the BookingDto
     * @return the Booking entity
     */
    public Booking toBookingEntity(final BookingDto bookingDto) {
        if (bookingDto
                == null) {
            return null;
        }
        return Booking.builder()
                .id(bookingDto.getId())
                .customerId(bookingDto.getCustomerId())
                .startDate(bookingDto.getStartDate())
                .endDate(bookingDto.getEndDate())
                .totalPrice(bookingDto.getTotalPrice()
                        != null
                        ?
                        BigDecimal.valueOf(bookingDto.getTotalPrice())
                        :
                        null)
                .status(bookingDto.getStatus())
                .appliedSeasonId(bookingDto.getAppliedSeasonId())
                .appliedMultiplier(bookingDto.getAppliedMultiplier()
                        != null
                        ?
                        BigDecimal.valueOf(bookingDto.getAppliedMultiplier())
                        :
                        null)
                .appliedSeasonName(bookingDto.getAppliedSeasonName())
                .build();
    }

    /**
     * Converts a Season entity to a SeasonDto.
     *
     * @param season the Season entity
     * @return the SeasonDto
     */
    public SeasonDto toSeasonDto(final Season season) {
        if (season
                == null) {
            return null;
        }
        return SeasonDto.builder()
                .id(season.getId())
                .name(season.getName())
                .startDate(season.getStartDate())
                .endDate(season.getEndDate())
                .priceMultiplier(season.getPriceMultiplier())
                .active(season.getActive())
                .build();
    }

    /**
     * Converts a SeasonDto to a Season entity.
     *
     * @param dto the SeasonDto
     * @return the Season entity
     */
    public Season toSeasonEntity(final SeasonDto dto) {
        if (dto
                == null) {
            return null;
        }
        return Season.builder()
                .id(dto.getId())
                .name(dto.getName())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .priceMultiplier(dto.getPriceMultiplier())
                .active(dto.getActive()
                        != null
                        ?
                        dto.getActive()
                        :
                        false)
                .build();
    }

    /**
     * Converts a Customer entity to a CustomerDto.
     *
     * @param customer the Customer entity
     * @return the CustomerDto
     */
    public CustomerDto toCustomerDto(final Customer customer) {
        if (customer
                == null) {
            return null;
        }
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }

    /**
     * Converts a CustomerDto to a Customer entity.
     *
     * @param customerDto the CustomerDto
     * @return the Customer entity
     */
    public Customer toCustomerEntity(final CustomerDto customerDto) {
        if (customerDto
                == null) {
            return null;
        }
        return Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .phoneNumber(customerDto.getPhoneNumber())
                .build();
    }

    /**
     * Converts a ServiceRequest entity to a ServiceRequestDto.
     *
     * @param serviceRequest the ServiceRequest entity
     * @return the ServiceRequestDto
     */
    public ServiceRequestDto toServiceRequestDto(
            final ServiceRequest serviceRequest) {
        if (serviceRequest
                == null) {
            return null;
        }
        return ServiceRequestDto.builder()
                .id(serviceRequest.getId())
                .serviceType(serviceRequest.getServiceType())
                .status(serviceRequest.getStatus())
                .cost(serviceRequest.getCost())
                .build();
    }

    /**
     * Converts a ServiceRequestDto to a ServiceRequest entity.
     *
     * @param dto     the ServiceRequestDto
     * @param booking the associated Booking entity
     * @return the ServiceRequest entity
     */
    public ServiceRequest toServiceRequestEntity(final ServiceRequestDto dto,
                                                 final Booking booking) {
        if (dto
                == null) {
            return null;
        }
        return ServiceRequest.builder()
                .id(dto.getId())
                .serviceType(dto.getServiceType())
                .status(dto.getStatus())
                .cost(dto.getCost())
                .build();
    }

    /**
     * Converts a Room entity to a RoomDto.
     *
     * @param room the Room entity
     * @return the RoomDto
     */
    public RoomDto toRoomDto(final Room room) {
        if (room
                == null) {
            return null;
        }
        return RoomDto.builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .roomType(room.getRoomType())
                .roomSize(room.getRoomSize())
                .roomMaxPersons(room.getRoomMaxPersons())
                .roomDescription(room.getRoomDescription())
                .basePrice(room.getBasePrice())
                .build();
    }

    /**
     * Converts a RoomDto to a Room entity.
     *
     * @param dto the RoomDto
     * @return the Room entity
     */
    public Room toRoomEntity(final RoomDto dto) {
        if (dto
                == null) {
            return null;
        }
        return Room.builder()
                .id(dto.getId())
                .roomNumber(dto.getRoomNumber())
                .roomType(dto.getRoomType())
                .roomSize(dto.getRoomSize())
                .roomMaxPersons(dto.getRoomMaxPersons())
                .roomDescription(dto.getRoomDescription())
                .basePrice(dto.getBasePrice())
                .build();
    }
}
