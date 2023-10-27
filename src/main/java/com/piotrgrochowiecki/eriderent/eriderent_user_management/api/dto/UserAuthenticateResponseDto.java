package com.piotrgrochowiecki.eriderent.eriderent_user_management.api.dto;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.model.Role;
import lombok.Builder;

@Builder
public record UserAuthenticateResponseDto(String uuid,
                                          String email,
                                          Role role,
                                          String password) {

}
