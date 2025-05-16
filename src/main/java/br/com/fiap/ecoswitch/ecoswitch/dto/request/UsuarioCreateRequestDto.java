package br.com.fiap.ecoswitch.ecoswitch.dto.request;

import br.com.fiap.ecoswitch.ecoswitch.commons.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record UsuarioCreateRequestDto(
        @NotNull
        String usuario,

        @NotNull @Email
        String email,

        @NotNull @Size(min=8, max = 20)
        String senha,

        @NotNull
        Role role
) {
}
