package com.example.homeworkspring.api.account;

import com.example.homeworkspring.api.account.web.CreateAccountDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountService {
    Account CreateAccount(CreateAccountDto accountDto);

    CollectionModel<?> findAllAccount();

    EntityModel<?> findAccountByUuid(String uuid);

    Account disableAccount(String uuid);
}
