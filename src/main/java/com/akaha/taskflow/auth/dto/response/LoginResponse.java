package com.akaha.taskflow.auth.dto.response;


import com.akaha.taskflow.auth.model.User;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO ответа при успешном входе")
public record LoginResponse(
        @Schema(description = "ID пользователя", example = "1")
        Long id,

        @Schema(description = "Email пользователя", example = "azamat@gmail.com")
        String email,

        @Schema(description = "Имя пользователя", example = "Азамат")
        String username,

        @Schema(description = "JWT токен для авторизации", example = "eyJhbGciOiJIUzI1NiJ9...")
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