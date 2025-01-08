package com.example.hotelReservation.controller;

import com.example.hotelReservation.dto.CustomerDto;
import com.example.hotelReservation.service.CustomerService;
// Replace wildcard imports:
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
 * Controller for handling customer-related requests.
 *
 * <p>Mark this class as final to indicate it's not designed for extension.
 * If you need to allow inheritance, remove 'final' and add Javadoc explaining
 * how to safely override each method.</p>
 */
@RestController
@RequestMapping("/api/customers")
public final class CustomerController {

    /**
     * Service used to manage customers.
     */
    private final CustomerService customerService;

    /**
     * Constructs a new {@code CustomerController}.
     *
     * @param service the service to handle customer operations
     */
    public CustomerController(final CustomerService service) {
        // Renamed constructor parameter to avoid "hidden field" warning.
        this.customerService = service;
    }

    /**
     * Retrieves all customers.
     *
     * @return a list of {@link CustomerDto} representing all customers
     */
    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     * Retrieves a customer by its ID.
     *
     * @param id the ID of the customer to retrieve
     * @return the found {@link CustomerDto}
     */
    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable final Integer id) {
        return customerService.getCustomerById(id);
    }

    /**
     * Creates a new customer.
     *
     * @param dto the {@link CustomerDto} containing customer data
     * @return the newly created {@link CustomerDto}
     */
    @PostMapping
    public CustomerDto createCustomer(
            @RequestBody final CustomerDto dto) {
        return customerService.createCustomer(dto);
    }

    /**
     * Updates an existing customer.
     *
     * @param id  the ID of the customer to update
     * @param dto the updated customer data
     * @return the updated {@link CustomerDto}
     */
    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable final Integer id,
                                      @RequestBody final CustomerDto dto) {
        return customerService.updateCustomer(id, dto);
    }

    /**
     * Deletes a customer by its ID.
     *
     * @param id the ID of the customer to delete
     */
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable final Integer id) {
        customerService.deleteCustomer(id);
    }
}
