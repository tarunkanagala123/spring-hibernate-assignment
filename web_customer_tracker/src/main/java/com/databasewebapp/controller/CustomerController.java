package com.databasewebapp.controller;


import com.databasewebapp.entity.Customer;
import com.databasewebapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel){
        //get customer from service
        List<Customer>theCustomers= customerService.getCustomers();
//        System.out.println("Size of customers list is "+theCustomers.size());
//        System.out.println(" ---Getting Customers List From Service-----"+theCustomers);

        //add customers to the model
        theModel.addAttribute("customers",theCustomers);

        return "list-customers";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to bind data
        Customer theCustomer=new Customer();

        theModel.addAttribute("customer",theCustomer);

        return "customer-form";
    }
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        //saving customer using service
        customerService.saveCustomer(theCustomer);
//        System.out.println("Customer Added Successfully!!!"+theCustomer);
        return "redirect:/customer/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel){

        //get customer from database
        Customer theCustomer=customerService.getCustomer(theId);

        //Set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){

        //delete the customer
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
    @GetMapping("/")
    public String displayHome(){
        return "index";
    }

}
