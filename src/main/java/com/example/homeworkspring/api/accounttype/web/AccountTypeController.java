package com.example.homeworkspring.api.accounttype.web;

import com.example.homeworkspring.api.accounttype.AccountTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account-type")
@RequiredArgsConstructor
public class AccountTypeController {
    private final AccountTypeService accountTypeService;

    @GetMapping
    public CollectionModel<?> getAllAccooutType(){
        return accountTypeService.findAllAccountType();
    }
    @GetMapping("/{id}")
    public EntityModel<?> getUserById(@PathVariable Integer id){
        return accountTypeService.findById(id);
    }


}
