package com.example.homeworkspring.api.user;

import com.example.homeworkspring.api.user.web.CreateUserDto;
import com.example.homeworkspring.api.user.web.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto toUserCreateDto(CreateUserDto createUserDto);
    CreateUserDto toUserDto(UserDto userDto);

    User toEntity(CreateUserDto createUserDto);


    UserDto mapUserToUserDto(User user);

    List<UserDto> mapProductsToProductDtoList(List<User> user);
}
