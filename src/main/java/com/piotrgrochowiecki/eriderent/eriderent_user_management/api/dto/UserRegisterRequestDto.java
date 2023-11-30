package com.piotrgrochowiecki.eriderent.eriderent_user_management.api.dto;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserRegisterRequestDto(@NotBlank String firstName,
                                     @NotBlank String lastName,
                                     @Email String email,
                                     @Past LocalDate drivingLicenseIssueDate,
                                     @NotNull Role role,
                                     @NotBlank String password) {

}
