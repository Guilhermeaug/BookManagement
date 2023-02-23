package com.guilhermeaug.bookmanagement.controller;

import com.guilhermeaug.bookmanagement.dto.request.PasswordPayload;
import com.guilhermeaug.bookmanagement.dto.request.UserRequestDto;
import com.guilhermeaug.bookmanagement.dto.response.UserResponseDto;
import com.guilhermeaug.bookmanagement.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserRequestDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("login")
    ResponseEntity checkCredentials(@RequestBody @Valid PasswordPayload payload) {
        return ResponseEntity.ok(userService.checkCredentials(payload));
    }

}
