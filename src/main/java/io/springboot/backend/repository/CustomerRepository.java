package io.springboot.backend.repository;

import io.springboot.backend.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("postgres")
public interface CustomerRepository {


    int insertCustomer(UUID id, Customer customer);

    default int insertCustomer(Customer customer){
        UUID id = UUID.randomUUID();
        return insertCustomer(id, customer);
    }

    Customer findByUserName(String username);

}
