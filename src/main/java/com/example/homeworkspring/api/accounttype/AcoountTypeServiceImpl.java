package com.example.homeworkspring.api.accounttype;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcoountTypeServiceImpl implements AccountTypeService{
    private final AccountTypeRepository  accountTypeRepository;
    private final AccountTypeAssembler accountTypeAssembler;
    @Override
    public CollectionModel<?> findAllAccountType() {
        List<AccountType> accountTypes=accountTypeRepository.findAll();
        return accountTypeAssembler.toCollectionModel(accountTypes);
    }

    @Override
    public EntityModel<?> findById(Integer id) {
        AccountType accountType=accountTypeRepository.findById(id).orElseThrow();
        return accountTypeAssembler.toModel(accountType);
    }
}
