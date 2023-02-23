package com.guilhermeaug.bookmanagement.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record CategoryRequestDto(
        @NotEmpty(message = "Forneça um título para a categoria") String title
) {
}
