package com.example.homeworkspring.api.base;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BaseApi<T>(
        String message,
        Integer code,
        Boolean status,
        LocalDateTime timeStamp,
        T data
) {
}
