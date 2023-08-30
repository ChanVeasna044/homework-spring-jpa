package com.example.homeworkspring.api.user;

import com.example.homeworkspring.api.user.web.CreateUserDto;
import com.example.homeworkspring.api.user.web.UpdateUserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.UUID;

public interface UserService {
    User CreateUser(CreateUserDto createUserDto);

    CollectionModel<?> findAllUser();

    EntityModel<?> findUserByUuid(String uuid);

    User disableUser(String uuid);


  User updateUserByUuid(String uuid, UpdateUserDto updatedUser);
//
    void deleteUserByUuid(String uuid);
}
