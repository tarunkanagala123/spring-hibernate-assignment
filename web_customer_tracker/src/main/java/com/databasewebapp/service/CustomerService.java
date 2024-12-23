package com.databasewebapp.service;

import com.databasewebapp.entity.Customer;

import java.util.List;

public interface CustomerService {
     List<Customer> getCustomers();
     void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

     void deleteCustomer(int theId);
}
