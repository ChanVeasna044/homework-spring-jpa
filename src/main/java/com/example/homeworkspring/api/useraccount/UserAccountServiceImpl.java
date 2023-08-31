package com.example.homeworkspring.api.useraccount;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepositoy userAccountRepositoy;
    private final UserAccountAssembler userAccountAssembler;

    @Override
    public EntityModel<?> findByIdUserAccount(Integer id) {
        UserAccount userAccount = userAccountRepositoy.findById(id).orElseThrow();
        return userAccountAssembler.toModel(userAccount);
    }

    @Override
    public CollectionModel<?> findAllUserAccount() {
        List<UserAccount> userAccounts = userAccountRepositoy.findAll();
        return userAccountAssembler.toCollectionModel(userAccounts);
    }
//
}
