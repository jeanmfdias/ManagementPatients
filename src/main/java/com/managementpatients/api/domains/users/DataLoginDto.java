package com.managementpatients.api.domains.users;

import jakarta.validation.constraints.NotBlank;

public record DataLoginDto(@NotBlank
                           String email,
                           @NotBlank
                           String password) {
}
