package com.ab.order.domain;

import java.util.Objects;

public class User {
    private long id;
    private UserRole role;
    private String email; // not blank, unique
    private String password;
    private String lastName; // not blank, unique
    private String firstName;
    private String address;
    private String phone; // not blank, unique

    private static long nextId = 1;

    public User(String email, String password, String lastName, String firstName, String address, String phone) {
        this.id = nextId++;
        this.role = UserRole.CUSTOMER;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
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

    @Override
    public String toString() {
        return "User " + id + " " + role + " " + email + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
