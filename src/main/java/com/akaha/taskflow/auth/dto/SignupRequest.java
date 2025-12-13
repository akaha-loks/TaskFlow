package com.akaha.taskflow.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;


public record SignupRequest(
        @NotBlank @Email String email,
        @NotBlank @Size(max = 50) String username,
        @NotBlank @Size(min = 6) String password
) {
}
