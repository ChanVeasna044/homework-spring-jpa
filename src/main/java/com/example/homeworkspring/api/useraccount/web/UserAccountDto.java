package com.example.homeworkspring.api.useraccount.web;

import com.example.homeworkspring.api.account.Account;
import com.example.homeworkspring.api.user.User;

import java.time.LocalDateTime;

public record UserAccountDto(
         Integer id,
         User user,
         Account account,
         LocalDateTime createdAt,
         LocalDateTime updateAt,
         Boolean isDisabled



) {
}
