package br.com.fiap.ecoswitch.ecoswitch.security.model;

import br.com.fiap.ecoswitch.ecoswitch.commons.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioLogin implements UserDetails {

    private String id;

    private String usuario;

    private String email;

    private String senha;

    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(Role.ADMIN.equals(this.role)) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.usuario;
    }
}
