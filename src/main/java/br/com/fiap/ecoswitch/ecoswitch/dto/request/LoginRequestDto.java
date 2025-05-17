package br.com.fiap.ecoswitch.ecoswitch.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record LoginRequestDto(
        @Email @NotNull
        String email,

        @NotNull
        String senha
) { }
