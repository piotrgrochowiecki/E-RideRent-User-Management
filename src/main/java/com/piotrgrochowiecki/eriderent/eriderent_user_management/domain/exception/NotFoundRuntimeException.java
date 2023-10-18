package com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.exception;

public class NotFoundRuntimeException extends RuntimeException {

    public NotFoundRuntimeException(String uuid) {
        super("User with uuid " + uuid + " has not been found");
    }

}
