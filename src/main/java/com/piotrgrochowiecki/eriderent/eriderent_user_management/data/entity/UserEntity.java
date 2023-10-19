package com.piotrgrochowiecki.eriderent.eriderent_user_management.data.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String uuid;

    String firstName;

    String lastName;

    @Column(unique = true)
    String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate drivingLicenseIssueDate;

    String password;

}
