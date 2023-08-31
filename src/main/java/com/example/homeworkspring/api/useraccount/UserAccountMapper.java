package com.example.homeworkspring.api.useraccount;

import com.example.homeworkspring.api.account.Account;
import com.example.homeworkspring.api.useraccount.web.UserAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {
    UserAccountMapper INSTANCE = Mappers.getMapper(com.example.homeworkspring.api.useraccount.UserAccountMapper.class);

    UserAccountDto mapUserAcconttoUserAccountDto(UserAccount userAccount);
    List<UserAccountDto> mapListUserAccountToListUserAccount(List<UserAccount> userAccounts);
}
