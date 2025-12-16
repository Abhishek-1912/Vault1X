package com.example.Vault1X.dto;

import com.example.Vault1X.entity.Users;

public class UserDto {
    private Long userId;
    private String username;
    private String email;

    // Only include necessary fields, not relationships

    // Constructors, getters, setters

    // Getters and Setters

    public static UserDto fromEntity(Users user) {
        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUserName());
        dto.setEmail(user.getEmail());

        // Check what methods are available in your Users entity
        // Option A: If Users has getFirstName()/getLastName()

        // Option B: If Users extends/extracts from UserDetails
        // Check what fields are actually in your Users class

        return dto;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getusername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getemail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
