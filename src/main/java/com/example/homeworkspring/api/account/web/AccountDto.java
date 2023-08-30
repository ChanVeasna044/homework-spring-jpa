package com.example.homeworkspring.api.account.web;

import com.example.homeworkspring.api.accounttype.AccountType;
import com.example.homeworkspring.api.useraccount.UserAccount;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

public record AccountDto(
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
){
}
