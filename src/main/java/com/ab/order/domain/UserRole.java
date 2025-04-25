package com.ab.order.domain;

public enum UserRole {
    CUSTOMER("Customer"),
    ADMIN("Admin");

    private String roleValue;

    UserRole(String roleValue) {
        this.roleValue = roleValue;
    }

    public String getRoleValue() {
        return roleValue;
    }

    @Override
    public String toString() {
        return roleValue;
    }
}
