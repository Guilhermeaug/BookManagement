package com.guilhermeaug.bookmanagement.service.implementation;

import com.guilhermeaug.bookmanagement.dto.mapper.UserMapper;
import com.guilhermeaug.bookmanagement.dto.request.PasswordPayload;
import com.guilhermeaug.bookmanagement.dto.request.UserRequestDto;
import com.guilhermeaug.bookmanagement.dto.response.UserResponseDto;
import com.guilhermeaug.bookmanagement.exception.EmailAlreadyExistsException;
import com.guilhermeaug.bookmanagement.exception.InvalidCredentialsException;
import com.guilhermeaug.bookmanagement.model.UserModel;
import com.guilhermeaug.bookmanagement.repository.UserRepository;
import com.guilhermeaug.bookmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userDto) {
        if (userRepository.findByEmail(userDto.email()).isPresent()) {
            throw new EmailAlreadyExistsException("This email already exists");
        }
        UserModel userModel = userMapper.userRequestDtoToUserModel(userDto);
        return userMapper.userModelToUserResponseDto(userRepository.save(userModel));
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::userModelToUserResponseDto)
                .toList();
    }

    @Override
    public boolean checkCredentials(PasswordPayload payload) {
        boolean exists = userRepository
                .existsByEmailAndPassword(payload.email(), payload.password());
        if (!exists)
            throw new InvalidCredentialsException("Credentials do not match");
        return true;
    }
}
