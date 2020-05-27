package io.springboot.backend.services;

import io.springboot.backend.model.Customer;

public interface CustomerService {


    //Customer findById(UUID customerId);

    Customer findByUserName(String name);

    //Customer findByName(String name);

    int createCustomer(Customer customer);

    //void saveCustomer(Customer customer);

    //void updateCustomer(Customer customer);

    //void deleteCustomerById(Long customerId);

    //void deleteAllCustomers();

    //List<Customer> findAllCustomers();

    //boolean customerExist(Customer customer);
}
