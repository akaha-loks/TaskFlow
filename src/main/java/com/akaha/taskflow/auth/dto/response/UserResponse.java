package com.akaha.taskflow.auth.dto.response;

import com.akaha.taskflow.auth.model.User;

public record UserResponse(Long id, String email, String username) {
    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getEmail(), user.getUsername());
    }
}
