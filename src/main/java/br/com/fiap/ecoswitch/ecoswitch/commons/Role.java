package br.com.fiap.ecoswitch.ecoswitch.commons;

public enum Role {
    ADMIN("admin"),
    USER("user");

    private String role;

    Role (String role) {
        this.role = role;
    }
}
