package com.example.homeworkspring.api.user;

import com.example.homeworkspring.api.account.Account;
import com.example.homeworkspring.api.user.web.CreateUserDto;
import com.example.homeworkspring.api.user.web.UpdateUserDto;
import com.example.homeworkspring.api.useraccount.UserAccount;
import com.example.homeworkspring.api.useraccount.UserAccountRepositoy;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserModelAssembler userModelAssembler;
    private final UserAccountRepositoy userAccountRepository;

    @Override
    public User CreateUser(CreateUserDto createUserDto) {
        User user = UserMapper.INSTANCE.toEntity(createUserDto);
        user.setUuid(String.valueOf(UUID.fromString(UUID.randomUUID().toString())));
        return userRepository.save(user);
    }

    @Override
    public CollectionModel<?> findAllUser() {
        List<User> users = userRepository.findAllByIsDeletedIsFalse();
        return userModelAssembler.toCollectionModel(users);
    }

    @Override
    public EntityModel<?> findUserByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid).orElseThrow();
        return userModelAssembler.toModel(user);
    }

    @Override
    public User disableUser(String uuid) {
        User existingUser = userRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        existingUser.setIsDeleted(true); // Disable the user
        BeanUtils.copyProperties(existingUser, uuid);
        return userRepository.save(existingUser);
    }

    @Override

    public User updateUserByUuid(String uuid, UpdateUserDto updatedUser) {
        User user = userRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));
        BeanUtils.copyProperties(updatedUser, user, uuid);

        return userRepository.save(user);
    }

//

    @Override
    public void deleteUserByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));

        userRepository.delete(user);
    }

    @Override
    public List<Account> getUserAccountsByUuid(String uuid) {
        List<UserAccount> userAccounts = userAccountRepository.findByUserUuid(uuid);
        List<Account> accounts = userAccounts.stream()
                .map(UserAccount::getAccount)
                .collect(Collectors.toList());
        return accounts;
    }

    @Override
    public Account getAccountByUserUuidAndAccountUuid(String userUuid, String accountUuid) {
        User user = userRepository.findByUuid(userUuid)
                .orElseThrow(() -> new EntityNotFoundException("User not found for the given UUID"));

        Optional<UserAccount> userAccount = userAccountRepository.findByUser_UuidAndAccount_Uuid(userUuid, accountUuid);

        if (userAccount.isPresent()) {
            return userAccount.get().getAccount();
        } else {
            throw new EntityNotFoundException("Account not found for the given user and account UUIDs.");
        }


    }
}
