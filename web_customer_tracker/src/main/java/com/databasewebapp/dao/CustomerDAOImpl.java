package com.databasewebapp.dao;

import com.databasewebapp.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Repository
public class CustomerDAOImpl implements CustomerDAO{

    // NEED TO INJECT HIBERNATE SESSION FACTORY
    @Autowired
private SessionFactory sessionFactory;

    @Override
  @Transactional
    public List<Customer> getCustomers() {
        //get current session
        Session currentSession=sessionFactory.getCurrentSession();
        //create query
        Query<Customer>theQuery=
                currentSession.createQuery(" from Customer ",Customer.class);

        //get result of query
        List<Customer> customers=theQuery.getResultList();
        System.out.println("Result of Query is ---Customers:\n"+customers);

        //return list
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        //get  current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();

        //save the customer (save or update) using merge

        currentSession.merge(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {

        //get current hibernate session
        Session currentSession= sessionFactory.getCurrentSession();

        // retrieve from database using primary key
        Customer theCustomer=currentSession.get(Customer.class,theId);

        return theCustomer ;
    }

    @Override
    public void deleteCustomer(int theId) {

        // get current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();

        //delete the object
        Query theQuery=currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId",theId);
        theQuery.executeUpdate();
    }
}
