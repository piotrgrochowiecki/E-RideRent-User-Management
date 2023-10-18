package com.piotrgrochowiecki.eriderent.eriderent_user_management.api.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record NotFoundRuntimeExceptionDto(String message,
                                          LocalDateTime timeStamp) {

}
