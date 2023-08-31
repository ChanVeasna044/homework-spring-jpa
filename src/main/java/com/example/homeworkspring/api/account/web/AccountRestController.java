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



    @PostMapping
    public EntityModel<?> createNewAccount(@RequestBody CreateAccountDto createAccountDto){
        return accountService.createNewAccount(createAccountDto);
    }

    @GetMapping
    public CollectionModel<?> findAllAccount() {
        return accountService.findAllAccount();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findAccountByUuid(@PathVariable String uuid) {
        return accountService.findAccountByUuid(uuid);
    }
    @PostMapping("/{uuid}/transferLimit")
    public EntityModel<?> changeTransferLimit(
            @PathVariable String uuid,
            @RequestBody ChangeTransferLimitDto changeTransferLimitDto){
        return accountService.changeTransferLimitByUuid(uuid, changeTransferLimitDto);
    }

    @PutMapping("/{uuid}/disable")
    public ResponseEntity<Account> disableAccountByUuid(@PathVariable String uuid) {
        Account account = accountService.disableAccount(uuid);
        return ResponseEntity.ok(account);
    }
}
