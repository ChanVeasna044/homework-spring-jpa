package com.example.homeworkspring.api.user.web;

import com.example.homeworkspring.api.userRole.UserRole;
import com.example.homeworkspring.api.useraccount.UserAccount;

import java.util.List;

public record CreateUserDto(
        Long id,
        String uuid,
        String name,
        String password,
        String email,
        String phoneNumber,
        Boolean isDelete,
        Boolean isStudent,
        Boolean isVerified,
        List<UserAccount> userAccounts,
        List<UserRole> userRoles
) {
}
