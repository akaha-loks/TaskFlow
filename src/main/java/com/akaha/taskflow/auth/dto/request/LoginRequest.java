package com.akaha.taskflow.auth.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "DTO для входа пользователя")
public record LoginRequest(
        @Schema(description = "Email пользователя", example = "azamat@gmail.com")
        @NotBlank String email,

        @Schema(description = "Пароль пользователя", example = "123456aka")
        @NotBlank @Size(min = 6) String password
) {
}
