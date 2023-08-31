package com.example.homeworkspring.api.account.web;

import com.example.homeworkspring.api.accounttype.AccountType;
import com.example.homeworkspring.api.useraccount.UserAccount;

import java.math.BigDecimal;
import java.util.List;

public record CreateAccountDto(
        String actName,
        String actNo,
        String uuid,
        String pin,
        BigDecimal transferLimit,
        Long accountTypeI
) {
}
