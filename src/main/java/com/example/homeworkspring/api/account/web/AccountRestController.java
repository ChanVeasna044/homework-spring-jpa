package com.example.homeworkspring.api.account.web;

import com.example.homeworkspring.api.account.Account;
import com.example.homeworkspring.api.account.AccountService;
import com.example.homeworkspring.api.base.BaseApi;
import com.example.homeworkspring.api.user.User;
import com.example.homeworkspring.api.user.UserService;
import com.example.homeworkspring.api.user.web.CreateUserDto;
import com.example.homeworkspring.api.user.web.UpdateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountRestController {

    private final AccountService accountService;

    @PostMapping("")
    public BaseApi<?> createAccount(@RequestBody CreateAccountDto createAccountDto) {

        Account account = accountService.CreateAccount(createAccountDto);

        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(account)
                .message("Nice")
                .timeStamp(LocalDateTime.now())
                .build();
    }



//    @DeleteMapping("/delete/{uuid}")
//    public BaseApi<?> deleteUser(@PathVariable("uuid") String uuid) {
//        accountService.d
//
//
//        return BaseApi.builder()
//                .code(HttpStatus.OK.value())
//                .data("your uuid delete : "+uuid)
//                .message("Nice")
//                .status(true)
//                .timeStamp(LocalDateTime.now())
//                .build();
//    }

    @GetMapping
    public CollectionModel<?> findAllAccount() {
        return accountService.findAllAccount();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findAccountByUuid(@PathVariable String uuid) {
        return accountService.findAccountByUuid(uuid);
    }

    @PutMapping("/{uuid}/disable")
    public ResponseEntity<Account> disableAccountByUuid(@PathVariable String uuid) {
        Account account = accountService.disableAccount(uuid);
        return ResponseEntity.ok(account);
    }
}
