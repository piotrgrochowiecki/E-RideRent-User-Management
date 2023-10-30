package com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.exception;

public class NotFoundRuntimeException extends RuntimeException {

    public NotFoundRuntimeException(String uuidOrEmail) {
        super("User " + uuidOrEmail + " has not been found");
    }

}
