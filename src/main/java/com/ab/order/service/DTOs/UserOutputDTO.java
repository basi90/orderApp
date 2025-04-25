package com.ab.order.service.DTOs;

import com.ab.order.domain.UserRole;

import java.util.Objects;

public class UserOutputDTO {
    private long id;
    private UserRole role;
    private String email;
    private String lastName;
    private String firstName;
    private String address;
    private String phoneNumber;

    public UserOutputDTO(long id,UserRole role, String email, String lastName, String firstName, String address, String phoneNumber) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public UserRole getRole() {
        return role;
    }

    public String getEmail() {
        return email;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserOutputDTO that = (UserOutputDTO) o;
        return id == that.id && role == that.role && Objects.equals(email, that.email) && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(address, that.address) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, email, lastName, firstName, address, phoneNumber);
    }
}
