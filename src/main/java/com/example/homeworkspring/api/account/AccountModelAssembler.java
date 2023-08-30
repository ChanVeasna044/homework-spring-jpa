package com.example.homeworkspring.api.account;

import com.example.homeworkspring.api.account.web.AccountDto;
import com.example.homeworkspring.api.account.web.AccountRestController;
import com.example.homeworkspring.api.user.web.UserController;
import com.example.homeworkspring.api.user.web.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@Configuration
public class AccountModelAssembler extends RepresentationModelAssemblerSupport<Account, EntityModel<AccountDto>> {
     private AccountMapper accountMapper;


    public AccountModelAssembler() {
        super(AccountRestController.class, (Class<EntityModel<AccountDto>>) (Class<?>)EntityModel.class );
    }

    @Autowired
    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public  EntityModel<AccountDto> toModel(Account entity) {
        AccountDto accountDto = AccountMapper.INSTANCE.mapAccountToAccountDto(entity);
        Link selfLink =linkTo(methodOn(AccountRestController.class).findAccountByUuid(entity.getUuid())).withSelfRel();
        Link collectionLink  =linkTo(methodOn(AccountRestController.class).findAllAccount()).withRel(IanaLinkRelations.COLLECTION);

        return EntityModel.of(accountDto,selfLink,collectionLink);

    }
}
