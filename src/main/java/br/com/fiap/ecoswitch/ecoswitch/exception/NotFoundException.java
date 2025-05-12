package br.com.fiap.ecoswitch.ecoswitch.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(final String message) {
        super(message);
    }

    public NotFoundException(final String message,final Throwable cause) {
        super(message, cause);
    }
}
