package com.guilhermeaug.bookmanagement.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record BookRequestDto(
        @NotEmpty String title,
        @NotEmpty String description,
        @NotNull int pages,
        @NotNull LocalDate publicationDate,
        @NotEmpty String photoUrl,
        @NotNull List<String> categories
        ) {
}
