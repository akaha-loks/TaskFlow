package com.akaha.taskflow.auth.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Schema(description = "DTO для регистрации")
public record SignupRequest(
        @Schema(description = "Email пользователя", example = "azamat@gmail.com")
        @NotBlank @Email String email,

        @Schema(description = "Имя пользователя", example = "Азамат")
        @NotBlank @Size(max = 50) String username,

        @Schema(description = "Пароль пользователя минимум 6 символов", example = "1234lol")
        @NotBlank @Size(min = 6) String password
) {
}