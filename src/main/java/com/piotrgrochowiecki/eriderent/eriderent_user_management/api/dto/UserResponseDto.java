package com.piotrgrochowiecki.eriderent.eriderent_user_management.api.dto;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.model.Role;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserResponseDto(Long id,
                              String uuid,
                              String firstName,
                              String lastName,
                              String email,
                              Role role,
                              LocalDate drivingLicenseIssueDate) {

}
