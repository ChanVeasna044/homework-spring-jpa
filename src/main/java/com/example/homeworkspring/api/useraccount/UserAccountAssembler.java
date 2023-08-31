package com.example.homeworkspring.api.useraccount;

import com.example.homeworkspring.api.account.Account;
import com.example.homeworkspring.api.account.web.AccountDto;
import com.example.homeworkspring.api.account.web.AccountRestController;
import com.example.homeworkspring.api.user.UserMapper;
import com.example.homeworkspring.api.useraccount.web.UserAccountController;
import com.example.homeworkspring.api.useraccount.web.UserAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@Configuration
public class UserAccountAssembler extends RepresentationModelAssemblerSupport<UserAccount, EntityModel<UserAccountDto>> {
    private UserAccountMapper userAccountMapper;


    public UserAccountAssembler() {
        super(UserAccountController.class, (Class<EntityModel<UserAccountDto>>) (Class<?>)EntityModel.class );
    }

    @Autowired
    public void setUserAccountMapper(UserAccountMapper userAccountMapper) {
        this.userAccountMapper = userAccountMapper;
    }




    public EntityModel<UserAccountDto> toModel(UserAccount entity) {
        UserAccountDto userAccountDto = UserAccountMapper.INSTANCE.mapUserAcconttoUserAccountDto(entity);
        Link sefLink = linkTo(methodOn(UserAccountController.class).findUserAccountById(entity.getId())).withSelfRel();
        Link collectionModel = linkTo(methodOn(UserAccountController.class).findUserAccount()).withRel(IanaLinkRelations.COLLECTION);


        return EntityModel.of(userAccountDto,sefLink,collectionModel);
    }

    @Override
    public CollectionModel<EntityModel<UserAccountDto>> toCollectionModel(Iterable<? extends UserAccount> entities) {
        return super.toCollectionModel(entities);
    }



}
