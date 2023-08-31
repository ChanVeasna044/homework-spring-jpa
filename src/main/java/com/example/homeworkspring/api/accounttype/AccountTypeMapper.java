package com.example.homeworkspring.api.accounttype;

import com.example.homeworkspring.api.accounttype.web.AccountTypeDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface AccountTypeMapper {
    AccountTypeDto AccountTypeToAccountTypeDto(AccountType accountType);
}
