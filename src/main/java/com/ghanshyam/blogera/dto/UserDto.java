package com.ghanshyam.blogera.dto;

public class UserDto {
    private String username;

    public UserDto(User user) {
        this.username = user.getUsername();
    }

    // Getter
    public String getUsername() {
        return username;
    }
}
