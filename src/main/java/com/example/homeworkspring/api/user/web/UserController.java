package com.example.homeworkspring.api.user.web;

import com.example.homeworkspring.api.account.Account;
import com.example.homeworkspring.api.base.BaseApi;
import com.example.homeworkspring.api.user.User;
import com.example.homeworkspring.api.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public BaseApi<?> createUser(@RequestBody CreateUserDto createUserDto) {

        User user = userService.CreateUser(createUserDto);

        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(user)
                .message("Nice")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @PutMapping("/update/{uuid}")
    public BaseApi<?> updateUser(@RequestBody UpdateUserDto createUserDto,@PathVariable("uuid") String uuid) {

        User user = userService.updateUserByUuid(uuid,createUserDto);

        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(user)
                .message("Nice")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @DeleteMapping("/delete/{uuid}")
    public BaseApi<?> deleteUser(@PathVariable("uuid") String uuid) {
        userService.deleteUserByUuid(uuid);


        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data("your uuid delete : "+uuid)
                .message("Nice")
                .status(true)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @GetMapping
    public CollectionModel<?> findUsers() {
        return userService.findAllUser();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findUsersByUuid(@PathVariable String uuid) {
        return userService.findUserByUuid(uuid);
    }

    @PutMapping("/{uuid}/disable")
    public ResponseEntity<User> disableUserByUuid(@PathVariable String uuid) {
        User user = userService.disableUser(uuid);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{uuid}/accounts")
    public ResponseEntity<List<Account>> getUserAccounts(@PathVariable String uuid) {
        List<Account> accounts = userService.getUserAccountsByUuid(uuid);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @GetMapping("/{userUu2id}/accounts/{accountUuid}")
    public ResponseEntity<Account> getAccountByUserAndAccountUuid(
            @PathVariable String userUuid,
            @PathVariable String accountUuid) {

        Account account = userService.getAccountByUserUuidAndAccountUuid(userUuid, accountUuid);
        return ResponseEntity.ok(account);
    }



}
