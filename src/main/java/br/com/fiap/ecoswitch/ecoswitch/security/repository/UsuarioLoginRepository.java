package br.com.fiap.ecoswitch.ecoswitch.security.repository;

import br.com.fiap.ecoswitch.ecoswitch.security.model.UsuarioLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioLoginRepository extends JpaRepository<UsuarioLogin, Long> {

    UserDetails findByEmail(String email);
}
