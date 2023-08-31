package com.example.homeworkspring.api.account;

import com.example.homeworkspring.api.account.web.ChangeTransferLimitDto;
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
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
   private final AccountRepository accountRepository;
    private final AccountModelAssembler accountModelAssembler;
    private final AccountMapper accountMapper;
//


    @Override
    public EntityModel<?> createNewAccount(CreateAccountDto createAccountDto) {
        Account account = accountMapper.mapCreateAccountDtoToAccount(createAccountDto);
        account.setUuid(UUID.randomUUID().toString());
        accountRepository.save(account);
        return accountModelAssembler.toModel(account);
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



        return accountRepository.save(existingAccount);
    }

    @Override
    public EntityModel<?> changeTransferLimitByUuid(String uuid, ChangeTransferLimitDto changeTransferLimitDto) {

            Optional<Account> optionalAccount = accountRepository.findAccountByUuid(uuid);
            if (optionalAccount.isPresent()){
                Account account = optionalAccount.get();

                account.setTransferLimit(changeTransferLimitDto.transferLimit1());
                accountRepository.save(account);
                return accountModelAssembler.toModel(account);
            }
            throw new RuntimeException("Not Found with this uuid");
        }
}
