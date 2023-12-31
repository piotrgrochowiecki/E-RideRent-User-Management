package com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.exception;

public class UserAlreadyExistsRuntimeException extends RuntimeException {

    public UserAlreadyExistsRuntimeException(String email) {
        super("User with email " + email + " already exists");
    }

}
