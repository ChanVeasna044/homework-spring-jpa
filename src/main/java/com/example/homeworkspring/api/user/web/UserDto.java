package com.example.homeworkspring.api.user.web;

import com.example.homeworkspring.api.userRole.UserRole;
import com.example.homeworkspring.api.useraccount.UserAccount;

import java.util.List;

public record UserDto(
        String uuid,
        String name,
        String password,
        String email,
        String phoneNumber,
        Boolean isDeleted,
        Boolean isStudent,
        Boolean isVerified,
        List<UserAccount> userAccounts,
        List<UserRole> userRoles
) {
}
