package com.databasewebapp.service;

import com.databasewebapp.dao.CustomerDAO;
import com.databasewebapp.entity.Customer;
import com.databasewebapp.service.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {

    @Mock
    private CustomerDAO customerDAO;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        // Initialize mock objects
        MockitoAnnotations.openMocks(this);

        // Create a mock Customer object
        customer = new Customer(1, "John", "Doe", "johndoe@example.com");
    }

    @Test
    void testGetCustomers() {
        // Prepare the mock behavior
        List<Customer> customerList = Arrays.asList(customer);
        when(customerDAO.getCustomers()).thenReturn(customerList);

        // Call the method
        List<Customer> result = customerService.getCustomers();

        // Verify the results
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstName());

        // Verify that DAO method was called
        verify(customerDAO, times(1)).getCustomers();
    }

    @Test
    void testSaveCustomer() {
        // Call the method
        customerService.saveCustomer(customer);

        // Verify that the DAO save method was called with the correct argument
        verify(customerDAO, times(1)).saveCustomer(customer);
    }

    @Test
    void testGetCustomer() {
        // Prepare the mock behavior
        when(customerDAO.getCustomer(1)).thenReturn(customer);

        // Call the method
        Customer result = customerService.getCustomer(1);

        // Verify the results
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("John", result.getFirstName());

        // Verify that DAO method was called
        verify(customerDAO, times(1)).getCustomer(1);
    }

    @Test
    void testDeleteCustomer() {
        // Call the method
        customerService.deleteCustomer(1);

        // Verify that the DAO delete method was called with the correct argument
        verify(customerDAO, times(1)).deleteCustomer(1);
    }
}
