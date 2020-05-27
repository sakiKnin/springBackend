package io.springboot.backend.services;

import io.springboot.backend.model.Customer;
import io.springboot.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findByUserName(String username) {
        return customerRepository.findByUserName(username);
    }

    public int createCustomer(Customer customer) {
        return customerRepository.insertCustomer(customer);
    }

}
