package com.databasewebapp.dao;

import com.databasewebapp.entity.Customer;


import java.util.List;

public interface CustomerDAO {
     List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
