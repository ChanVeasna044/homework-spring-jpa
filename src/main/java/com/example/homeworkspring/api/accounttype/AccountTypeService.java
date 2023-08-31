package com.example.homeworkspring.api.accounttype;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountTypeService {
    CollectionModel<?> findAllAccountType();
    EntityModel<?> findById(Integer id);
}
