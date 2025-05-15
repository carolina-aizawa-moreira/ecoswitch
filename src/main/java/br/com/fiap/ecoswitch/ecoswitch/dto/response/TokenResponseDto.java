package br.com.fiap.ecoswitch.ecoswitch.dto.response;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record TokenResponseDto(String token) {
}
