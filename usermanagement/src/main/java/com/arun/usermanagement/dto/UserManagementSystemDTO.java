package com.arun.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserManagementSystemDTO {
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
