package br.com.fiap.ecoswitch.ecoswitch.exception;

public class DuplicateNomeProdutoException extends RuntimeException{
    public DuplicateNomeProdutoException(final String message){
        super(message);
    }

    public DuplicateNomeProdutoException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
