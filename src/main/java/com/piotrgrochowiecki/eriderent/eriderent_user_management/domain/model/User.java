package com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.model;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record User(Long id,
                   String uuid,
                   String firstName,
                   String lastName,
                   String email,
                   LocalDate drivingLicenseIssueDate,
                   String password) {

}
