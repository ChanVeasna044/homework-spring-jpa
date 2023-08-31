package com.example.homeworkspring.api.accounttype;

import com.example.homeworkspring.api.accounttype.web.AccountTypeController;
import com.example.homeworkspring.api.accounttype.web.AccountTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeAssembler extends RepresentationModelAssemblerSupport<AccountType, EntityModel<AccountTypeDto>> {
    private AccountTypeMapper accountTypeMapper;
    @Autowired
    public void setAccountTypeMapper(AccountTypeMapper accountTypeMapper) {
        this.accountTypeMapper = accountTypeMapper;
    }

    @SuppressWarnings("unchecked")
    public AccountTypeAssembler() {
        super(AccountTypeController.class,(Class<EntityModel<AccountTypeDto>>) (Class<?>)EntityModel.class);
    }

    @Override
    public CollectionModel<EntityModel<AccountTypeDto>> toCollectionModel(Iterable<? extends AccountType> entities) {
        return super.toCollectionModel(entities);
    }

    @Override
    public EntityModel<AccountTypeDto> toModel(AccountType entity) {
        AccountTypeDto accountTypeDto = accountTypeMapper.AccountTypeToAccountTypeDto(entity);
        Link collectionLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountTypeController.class).getAllAccooutType())
                .withRel(IanaLinkRelations.COLLECTION);
        Link seftLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountTypeController.class).getUserById(entity.getId()))
                .withSelfRel();
        return EntityModel.of(accountTypeDto,seftLink,collectionLink);
    }
}