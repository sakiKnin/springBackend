package io.springboot.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID customerId;

    @NonNull
    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @NonNull
    @Column(name = "address", length = 512, nullable = false)
    private String address;

    @NonNull
    @Column(name = "email", length = 128, nullable = false)
    private String email;

    @NonNull
    @Column(name = "phone", length = 32, nullable = false)
    private String phone;

    @NonNull
    @Column(name = "username", length = 255, nullable = false)
    private String username;

    @NonNull
    @Column(name = "pasword", length = 255, nullable = false)
    private String password;

    @NonNull
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @NonNull
    @Column(name = "role", length = 255, nullable = false)
    private String role;

    public Customer(@JsonProperty("id") UUID customerId, @JsonProperty("name") @NonNull String name, @JsonProperty("address") @NonNull String address,@JsonProperty("email") @NonNull String email,@JsonProperty("phone") @NonNull String phone,@JsonProperty("username") @NonNull String username,@JsonProperty("password") @NonNull String password,@JsonProperty("enabled") boolean enabled,@JsonProperty("role") @NonNull String role) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @NonNull
    public String getRole() {
        return role;
    }
}
