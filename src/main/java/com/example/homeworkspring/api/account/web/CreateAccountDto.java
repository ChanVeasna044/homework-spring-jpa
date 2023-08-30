package com.example.homeworkspring.api.account.web;

import com.example.homeworkspring.api.accounttype.AccountType;
import com.example.homeworkspring.api.useraccount.UserAccount;

import java.util.List;

public record CreateAccountDto(
        Integer id,

        String uuid,


        String accountNo,
        String accountName,
        String profile,
        Integer pin,
        String phoneNumber,
        Integer transferLimit,

        List<UserAccount> userAccounts,


        AccountType accountType
) {
}
