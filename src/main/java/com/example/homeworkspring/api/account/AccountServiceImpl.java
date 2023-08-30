package com.example.homeworkspring.api.account;

import com.example.homeworkspring.api.account.web.CreateAccountDto;
import com.example.homeworkspring.api.user.User;
import com.example.homeworkspring.api.user.UserModelAssembler;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
   private final AccountRepository accountRepository;
    private final AccountModelAssembler accountModelAssembler;
//
    @Override
    public Account CreateAccount(CreateAccountDto accountDto) {
        return null;
    }

    @Override
    public CollectionModel<?> findAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return accountModelAssembler.toCollectionModel(accounts);
    }

    @Override
    public EntityModel<?> findAccountByUuid(String uuid) {
        Account account = accountRepository.findAccountByUuid(uuid) .orElseThrow();
        return accountModelAssembler.toModel(account);
    }

    @Override
    public Account disableAccount(String uuid) {
        Account existingAccount = accountRepository.findAccountByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));

        ; // Disable the user

        return accountRepository.save(existingAccount);
    }
}
