package com.ab.order.domain;

public enum UserRole {
    CUSTOMER("CUSTOMER"),
    ADMIN("ADMIN");

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
