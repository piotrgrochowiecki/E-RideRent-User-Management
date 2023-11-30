package com.piotrgrochowiecki.eriderent.eriderent_user_management.api.mapper;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.api.dto.UserAuthenticateResponseDto;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.api.dto.UserRegisterRequestDto;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.api.dto.UserResponseDto;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserApiMapper {

    public User mapToUser(UserRegisterRequestDto userRegisterRequestDto) {
        return User.builder()
                .firstName(userRegisterRequestDto.firstName())
                .lastName(userRegisterRequestDto.lastName())
                .email(userRegisterRequestDto.email())
                .drivingLicenseIssueDate(userRegisterRequestDto.drivingLicenseIssueDate())
                .role(userRegisterRequestDto.role())
                .password(userRegisterRequestDto.password())
                .build();
    }

    public UserResponseDto mapToUserResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.id())
                .uuid(user.uuid())
                .firstName(user.firstName())
                .lastName(user.lastName())
                .email(user.email())
                .drivingLicenseIssueDate(user.drivingLicenseIssueDate())
                .role(user.role())
                .build();
    }

    public UserAuthenticateResponseDto mapToUserAuthenticateDto(User user) {
        return UserAuthenticateResponseDto.builder()
                .uuid(user.uuid())
                .email(user.email())
                .role(user.role())
                .password(user.password())
                .build();
    }

}
