package io.springboot.backend.repository;

import io.springboot.backend.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerRepositoryImpl implements CustomerRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCustomer(UUID id, Customer customer){

        final String sql = "INSERT INTO customers (id, name) VALUES (?, ?)";

        return jdbcTemplate.update(sql, id, customer.getName());
    }

    @Override
    public Customer findByUserName(String username){
        System.out.println(username);
        final String sql = "SELECT id, name, address, email, phone, username, password, enabled, role FROM customers WHERE username=?";

        try {
            Customer customer = jdbcTemplate.queryForObject(
                    sql,
                    new Object[]{username},
                    (resultSet, i) -> {
                        UUID id = UUID.fromString(resultSet.getString("id"));
                        String name = resultSet.getString("name");
                        String address = resultSet.getString("address");
                        String email = resultSet.getString("email");
                        String phone = resultSet.getString("phone");
                        String userName = resultSet.getString("username");
                        String password = resultSet.getString("password");
                        Boolean enabled = resultSet.getBoolean("enabled");
                        String role = resultSet.getString("role");
                        return new Customer(
                                id,
                                name,
                                address,
                                email,
                                phone,
                                userName,
                                password,
                                enabled,
                                role
                        );
                    });

            return customer;

        }catch(EmptyResultDataAccessException e) {

            return null;
        }
    }
}
