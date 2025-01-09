package com.example.hotelReservation.service;

import com.example.hotelReservation.dto.CustomerDto;
import com.example.hotelReservation.model.Customer;
import com.example.hotelReservation.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing customers in the Hotel Reservation system.
 */
@Service
public final class CustomerService {

    /**
     * Repository for accessing customer data.
     */
    private final CustomerRepository customerRepository;

    /**
     * Mapper for converting between entities and DTOs.
     */
    private final DtoMapper dtoMapper;

    /**
     * Constructor for CustomerService.
     *
     * @param repository the customer repository
     * @param mapper     the DTO mapper
     */
    public CustomerService(
            final CustomerRepository repository,
            final DtoMapper mapper) {
        this.customerRepository = repository;
        this.dtoMapper = mapper;
    }

    /**
     * Retrieves all customers.
     *
     * @return a list of customer DTOs
     */
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(dtoMapper::toCustomerDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a customer by their ID.
     *
     * @param id the ID of the customer
     * @return the customer DTO
     */
    public CustomerDto getCustomerById(final Integer id) {
        return customerRepository.findById(id)
                .map(dtoMapper::toCustomerDto)
                .orElseThrow(() -> new RuntimeException(
                        "Customer not found with id " + id));
    }

    /**
     * Creates a new customer.
     *
     * @param customerDto the customer DTO
     * @return the created customer DTO
     */
    public CustomerDto createCustomer(final CustomerDto customerDto) {
        Customer customer = dtoMapper.toCustomerEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return dtoMapper.toCustomerDto(savedCustomer);
    }

    /**
     * Updates an existing customer.
     *
     * @param id          the ID of the customer to update
     * @param customerDto the updated customer DTO
     * @return the updated customer DTO
     */
    public CustomerDto updateCustomer(final Integer id,
                                      final CustomerDto customerDto) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Customer not found with id " + id));

        existingCustomer.setName(customerDto.getName());
        existingCustomer.setEmail(customerDto.getEmail());
        existingCustomer.setPhoneNumber(customerDto.getPhoneNumber());

        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return dtoMapper.toCustomerDto(updatedCustomer);
    }

    /**
     * Deletes a customer by their ID.
     *
     * @param id the ID of the customer to delete
     */
    public void deleteCustomer(final Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with id " + id);
        }
        customerRepository.deleteById(id);
    }
}
