package com.akaha.taskflow.auth.dto.response;

import com.akaha.taskflow.auth.model.User;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO ответа при успешной регистрации")
public record UserResponse(
        @Schema(description = "ID пользователя", example = "1")
        Long id,

        @Schema(description = "Email пользователя", example = "azamat@gmail.com")
        String email,

        @Schema(description = "Имя пользователя", example = "Азамат")
        String username) {
    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getEmail(), user.getUsername());
    }
}
