package com.guilhermeaug.bookmanagement.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserRequestDto(
        @NotEmpty(message = "Insira o nome do usuário") String name,
        @NotEmpty(message = "Insira a senha") String password,
        @NotEmpty @Email(message = "Formato do email está incorreto") String email,
        @NotEmpty(message = "O código de matrícula é necessário") String code
) {
}
