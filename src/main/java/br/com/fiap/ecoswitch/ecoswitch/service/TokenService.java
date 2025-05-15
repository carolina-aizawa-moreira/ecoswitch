package br.com.fiap.ecoswitch.ecoswitch.service;

import br.com.fiap.ecoswitch.ecoswitch.security.model.UsuarioLogin;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Slf4j
@Service
public class TokenService {

    @Value("${SECRET}")
    private String secret;

    public String generateToken(final UsuarioLogin usuario) {
        try {
            final Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("contatos")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(geraDataExpericao())
                    .sign(algorithm);
        } catch (final JWTCreationException e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    public String validarToken(final String token) {
        try {
            final Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("contatos").build()
                    .verify(token)
                    .getSubject();
        } catch (final JWTVerificationException e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    private Instant geraDataExpericao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }


}
