package com.guilhermeaug.bookmanagement.service;

import com.guilhermeaug.bookmanagement.dto.request.PasswordPayload;
import com.guilhermeaug.bookmanagement.dto.request.UserRequestDto;
import com.guilhermeaug.bookmanagement.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userDto);
    List<UserResponseDto> getAllUsers();
    boolean checkCredentials(PasswordPayload payload);
}
