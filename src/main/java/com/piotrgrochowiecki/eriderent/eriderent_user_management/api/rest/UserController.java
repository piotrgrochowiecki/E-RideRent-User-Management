package com.piotrgrochowiecki.eriderent.eriderent_user_management.api.rest;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.api.dto.UserAuthenticateResponseDto;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.api.dto.UserRegisterRequestDto;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.api.dto.UserResponseDto;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.api.mapper.UserApiMapper;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.model.User;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/internal/user")
@Validated
public class UserController {

    private final UserService userService;
    private final UserApiMapper userApiMapper;

    @GetMapping("uuid/{uuid}")
    public UserResponseDto getByUuid(@PathVariable("uuid") @NotBlank String uuid) {
        User user = userService.getByUuid(uuid); //TODO pomyśleć nad zamianą uuid na id
        return userApiMapper.mapToUserResponseDto(user);
    }

    @GetMapping("email/{email}")
    public UserAuthenticateResponseDto getByEmail(@PathVariable @Email String email) {
        User user = userService.getByEmail(email);
        return userApiMapper.mapToUserAuthenticateDto(user);
    }

    @PostMapping("create")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody UserRegisterRequestDto userRegisterRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(fieldError -> System.out.println(fieldError.getField() + ": " + fieldError.getDefaultMessage() + "\n"));
        }
        User userToBeRegistered = userApiMapper.mapToUser(userRegisterRequestDto);
        User registeredUser = userService.registerNewUser(userToBeRegistered);
        return new ResponseEntity<>(userApiMapper.mapToUserResponseDto(registeredUser), HttpStatus.CREATED);
    }

}
