package com.example.homeworkspring.api.account;

import com.example.homeworkspring.api.account.web.ChangeTransferLimitDto;
import com.example.homeworkspring.api.account.web.CreateAccountDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountService {
    EntityModel<?> createNewAccount(CreateAccountDto createAccountDto);

    CollectionModel<?> findAllAccount();

    EntityModel<?> findAccountByUuid(String uuid);

    Account disableAccount(String uuid);

    EntityModel<?> changeTransferLimitByUuid
            (String uuid, ChangeTransferLimitDto changeTransferLimitDto);
}
