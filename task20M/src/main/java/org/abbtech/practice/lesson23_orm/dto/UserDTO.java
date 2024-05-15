package org.abbtech.practice.lesson23_orm.dto;

import jakarta.validation.constraints.*;

import java.util.Set;

public record UserDTO(
        @NotNull @NotBlank @Size(min = 7, max = 15) String username,
        @Email String email,
        @NotNull @NotBlank @Size(min = 10, max = 15) @Pattern(regexp = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$\n") String password,
        @NotEmpty Set<@NotBlank String> roles
        ) {
}
