package com.ab.order.service.DTOs;

public class UserInputDTO {
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;

    public UserInputDTO(String email, String password, String lastName, String firstName, String address, String phone) {
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }
}
