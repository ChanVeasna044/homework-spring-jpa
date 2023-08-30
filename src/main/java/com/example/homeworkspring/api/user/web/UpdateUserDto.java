package com.example.homeworkspring.api.user.web;

public record UpdateUserDto(
        String uuid,
        String name,
        String password,
        String email,
        String phoneNumber,
        Boolean isDelete,
        Boolean isStudent,
        Boolean isVerified
) {
}
