package com.piotrgrochowiecki.eriderent.eriderent_user_management.data;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity mapToEntity(User user) {
        return UserEntity.builder()
                .id(user.id())
                .uuid(user.uuid())
                .firstName(user.firstName())
                .lastName(user.lastName())
                .email(user.email())
                .drivingLicenseIssueDate(user.drivingLicenseIssueDate())
                .password(user.password())
                .build();
    }

    public User mapToModel(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .uuid(userEntity.getUuid())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .drivingLicenseIssueDate(userEntity.getDrivingLicenseIssueDate())
                .password(userEntity.getPassword())
                .build();
    }

}
