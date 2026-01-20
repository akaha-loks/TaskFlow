package com.akaha.taskflow.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank String email,
        @NotBlank @Size(min = 6) String password

) {
}
