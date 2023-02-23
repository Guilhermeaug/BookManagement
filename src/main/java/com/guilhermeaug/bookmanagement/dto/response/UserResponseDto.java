package com.guilhermeaug.bookmanagement.dto.response;

public record UserResponseDto (
        Long id,
        String name,
        String email,
        String code
) {
}
