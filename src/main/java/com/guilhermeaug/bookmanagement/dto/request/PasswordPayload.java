package com.guilhermeaug.bookmanagement.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PasswordPayload(
        @NotNull(message = "You need to specify the user EMAIL") @NotEmpty String email,
        @NotNull(message = "You need to specify the user PASSWORD") @NotEmpty String password
) {
}
