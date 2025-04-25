package com.ab.order.service.DTOs;

public class UserInputDTO {
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private String address;
    private String phoneNumber;

    public UserInputDTO(String email, String password, String lastName, String firstName, String address, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
