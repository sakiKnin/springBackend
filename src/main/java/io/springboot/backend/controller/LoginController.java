package io.springboot.backend.controller;

import io.springboot.backend.model.Customer;
import io.springboot.backend.services.CustomerService;
import io.springboot.backend.util.JwtUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Objects;

@RestController
public class LoginController {

    private final CustomerService customerService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    private static class UserLogin {
        public String username;
        public String password;
    }

    @RequestMapping({"/hello"})
    public String hello() {
        return "hello world";
    }

    @Autowired
    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody final UserLogin login)
            throws ServletException {

        Customer customer;
        JSONObject responseToken = new JSONObject();
        customer = customerService.findByUserName(login.username);

        if (customer == null) {
            return ResponseEntity.ok("This username doesn't exists!");
        } else if (Objects.deepEquals(login.username, customer.getUsername()) && !Objects.equals(login.password, customer.getPassword())) {
            return ResponseEntity.ok("wrong password");
        } else {
            final String token = jwtTokenUtil.generateToken(customer);
            try {
                responseToken.put("token", token);
            }catch(JSONException e){

            }
            //return ResponseEntity.ok(responseToken);
            return new ResponseEntity<String>(responseToken.toString(), HttpStatus.OK);

        }
    }
}
