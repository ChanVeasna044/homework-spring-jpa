package com.example.homeworkspring.api.useraccount;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import javax.swing.text.html.parser.Entity;

public interface UserAccountService {
    EntityModel<?> findByIdUserAccount(Integer id);
    CollectionModel<?> findAllUserAccount();
}
