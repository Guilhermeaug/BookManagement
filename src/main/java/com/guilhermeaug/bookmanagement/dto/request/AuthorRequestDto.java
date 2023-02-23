package com.guilhermeaug.bookmanagement.dto.request;

import java.time.LocalDate;

public record AuthorRequestDto(
        String name,
        LocalDate birthDate
) {
}
