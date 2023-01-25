package com.example.parliamobackend.user.authorities;

public enum UserPermissions {

    USER_READ("user:read"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");

    // Variable
    private final String userPermission;

    // Constructor
    UserPermissions(String userPermission) {
        this.userPermission = userPermission;
    }

    // Getter
    public String getUserPermission() {
        return userPermission;
    }
}



