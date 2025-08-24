package br.com.fiap.ecoswitch.ecoswitch.security.repository;

import br.com.fiap.ecoswitch.ecoswitch.security.model.UsuarioLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioLoginRepository extends MongoRepository<UsuarioLogin, Long> {

    UserDetails findByEmail(String email);

    Optional<UsuarioLogin> findByUsuarioOrEmail(String usuario, String email);
}
