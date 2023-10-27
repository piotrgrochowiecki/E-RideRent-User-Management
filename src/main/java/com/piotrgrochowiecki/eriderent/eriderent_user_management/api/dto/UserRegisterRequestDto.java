package com.piotrgrochowiecki.eriderent.eriderent_user_management.api.dto;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.model.Role;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserRegisterRequestDto(String firstName,
                                     String lastName,
                                     String email,
                                     LocalDate drivingLicenseIssueDate,
                                     Role role,
                                     String password) {

}
