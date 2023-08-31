package com.example.homeworkspring.api.useraccount.web;

import com.example.homeworkspring.api.useraccount.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-account")
public class UserAccountController {
    private final UserAccountService userAccountService;

    @GetMapping
    public CollectionModel<?> findUserAccount() {
        return userAccountService.findAllUserAccount();
    }

    @GetMapping("/{id}")
    public EntityModel<?> findUserAccountById(@PathVariable("id") Integer id) {
        return userAccountService.findByIdUserAccount(id);
    }
}
