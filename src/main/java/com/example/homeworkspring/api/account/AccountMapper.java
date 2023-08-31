package com.example.homeworkspring.api.account;

import com.example.homeworkspring.api.account.web.AccountDto;
import com.example.homeworkspring.api.account.web.CreateAccountDto;
import com.example.homeworkspring.api.user.User;
import com.example.homeworkspring.api.user.UserMapper;
import com.example.homeworkspring.api.user.web.CreateUserDto;
import com.example.homeworkspring.api.user.web.UserDto;
import com.example.homeworkspring.api.useraccount.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(com.example.homeworkspring.api.account.AccountMapper.class);
    AccountDto toAccountCreateDto(CreateAccountDto createAccountDto);
    CreateAccountDto toAccountDto(AccountDto accountDto);

    Account toEntity(CreateAccountDto createAccountDto);


    AccountDto mapAccountToAccountDto(Account account);

     Account mapCreateAccountDtoToAccount(CreateAccountDto createAccountDto);




}
