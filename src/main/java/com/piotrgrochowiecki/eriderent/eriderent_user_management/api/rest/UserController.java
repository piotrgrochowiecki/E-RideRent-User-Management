package com.piotrgrochowiecki.eriderent.eriderent_user_management.api.rest;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.api.dto.UserRegisterRequestDto;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.api.dto.UserResponseDto;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.api.mapper.UserApiMapper;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.User;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/internal/user/")
public class UserController {

    private final UserService userService;
    private final UserApiMapper userApiMapper;

    @GetMapping("{uuid}")
    public UserResponseDto getByUuid(@PathVariable @Nullable String uuid) {
        User user = userService.getByUuid(uuid);
        return userApiMapper.mapToUserResponseDto(user);
    }

    @PostMapping("create")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        User userToBeRegistered = userApiMapper.mapToUser(userRegisterRequestDto);
        User registeredUser = userService.registerNewUser(userToBeRegistered);
        return new ResponseEntity<>(userApiMapper.mapToUserResponseDto(registeredUser), HttpStatus.CREATED);
    }

}
