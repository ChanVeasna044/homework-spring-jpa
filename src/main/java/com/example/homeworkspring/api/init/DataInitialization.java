package com.example.homeworkspring.api.init;

import com.example.homeworkspring.api.account.Account;
import com.example.homeworkspring.api.account.AccountRepository;
import com.example.homeworkspring.api.accounttype.AccountType;
import com.example.homeworkspring.api.accounttype.AccountTypeRepository;
import com.example.homeworkspring.api.user.User;
import com.example.homeworkspring.api.user.UserRepository;
import com.example.homeworkspring.api.useraccount.UserAccount;
import com.example.homeworkspring.api.useraccount.UserAccountRepositoy;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitialization {
    private AccountTypeRepository accountTypeRepository;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    private final UserAccountRepositoy userAccountRepository;

    @PostConstruct
    void init() {
        System.out.println("Start initialize data...");

        Account account = Account.builder().accountName("LimHai").accountNo("172212").pin(323445).transferLimit(3324).uuid(String.valueOf(UUID.randomUUID())).build();
        Account account1 = Account.builder().accountName("heng").accountNo("172212").pin(323445).transferLimit(213).uuid(String.valueOf(UUID.randomUUID())).build();
//        Account account2 = Account.builder().accountName("hong").accountNo("172212").pin(323445").transferLimit(223.00).uuid(UUID.randomUUID()).build();
//        Account account3 = Account.builder().actName("Heang").actNo("172212").pin("323445").transferLimit(233.00).uuid(UUID.randomUUID()).build();
        //Save account
        accountRepository.saveAll(List.of(account, account1));

        User user = User.builder().email("limhaifc@gmail.com").name("LimHai").password(String.valueOf(UUID.randomUUID())).isStudent(true).isDeleted(false).phoneNumber("012349929").uuid(String.valueOf(UUID.randomUUID())).build();
        User user1 = User.builder().email("heng@gmail.com").name("heng").password(String.valueOf(UUID.randomUUID())).isStudent(true).isDeleted(false).phoneNumber("012433434").uuid(String.valueOf(UUID.randomUUID())).build();
////        User user2 = User.builder().email("hong@gmail.com").name("hong").password(String.valueOf(UUID.randomUUID())).isStudent(true).isDelete(false).phoneNumber("098334334").uuid(String.valueOf(UUID.randomUUID())).build();
////        User user3 = User.builder().email("hack@gmail.com").name("heang").password(String.valueOf(UUID.randomUUID())).isStudent(true).isDelete(false).phoneNumber("02134343").uuid(String.valueOf(UUID.randomUUID())).build();
//
        userRepository.saveAll(List.of(user, user1));
//
        UserAccount userAccount = UserAccount.builder().isDisabled(true).build();
        UserAccount userAccount2 = UserAccount.builder().isDisabled(true).build();
////        UserAccount userAccount3 = UserAccount.builder().isDisabled(true).build();
////        UserAccount userAccount4 = UserAccount.builder().isDisabled(true).build();
////        UserAccount userAccount5 = UserAccount.builder().isDisabled(true).build();
        userAccountRepository.saveAll(List.of(userAccount,userAccount2));

//        AccountTypeRepository accountTypeRepository = AccountType.builder().id(1).name("veasna").build();
//    }
//        AccountType accountType = AccountType.builder().name("SavingAccount").build();

    }
}
