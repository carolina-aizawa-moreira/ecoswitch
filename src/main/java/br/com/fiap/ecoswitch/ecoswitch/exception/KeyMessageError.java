package br.com.fiap.ecoswitch.ecoswitch.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum KeyMessageError {
    DISPOSITIVO_ELETRONICO_NAO_CADASTRADO("dispositivo.eletronico.nao.cadastrado"),
    USUARIO_JA_CADASTRADO("usuario.jacadastrado");

    private final String message;

    private KeyMessageError(final String message) {
        this.message = message;
    }
}
