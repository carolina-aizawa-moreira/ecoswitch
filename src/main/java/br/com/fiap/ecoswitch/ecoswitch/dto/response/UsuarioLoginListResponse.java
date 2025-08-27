package br.com.fiap.ecoswitch.ecoswitch.dto.response;

import br.com.fiap.ecoswitch.ecoswitch.commons.Role;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record UsuarioLoginListResponse(
        String id,
        String usuario,
        String email,
        Role role
) {
}
