package com.akaha.taskflow.auth.dto.response;


import com.akaha.taskflow.auth.model.User;

public record LoginResponse(
        Long id,
        String email,
        String username,
        String token
) {
    public static LoginResponse from(User user, String token) {
        return new LoginResponse(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                token
        );
    }
}