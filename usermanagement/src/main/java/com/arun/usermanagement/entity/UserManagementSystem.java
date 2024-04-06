package com.arun.usermanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "user_management_system")
@Getter
@Setter
@Data
public class UserManagementSystem {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String gender;
    private String birthday;

}
