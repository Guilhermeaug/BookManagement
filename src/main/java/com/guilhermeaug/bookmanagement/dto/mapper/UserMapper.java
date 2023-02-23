package com.guilhermeaug.bookmanagement.dto.mapper;

import com.guilhermeaug.bookmanagement.dto.request.UserRequestDto;
import com.guilhermeaug.bookmanagement.dto.response.UserResponseDto;
import com.guilhermeaug.bookmanagement.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserResponseDto userModelToUserResponseDto(UserModel userModel);

    @Mapping(target = "id", ignore = true)
    UserModel userRequestDtoToUserModel(UserRequestDto userRequestDto);
}
