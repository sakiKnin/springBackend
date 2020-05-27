package io.springboot.backend.controller;

import io.springboot.backend.model.Customer;
import io.springboot.backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final CustomerService customerService;

    @RequestMapping({"/hello"})
    public String hello(){
        return "hello world";
    }

    @Autowired
    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Customer loginCustomer(@NonNull @RequestBody String username){
        return customerService.findByUserName(username);
    }
}
