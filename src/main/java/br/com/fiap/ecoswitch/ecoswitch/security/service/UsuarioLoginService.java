package br.com.fiap.ecoswitch.ecoswitch.security.service;

import br.com.fiap.ecoswitch.ecoswitch.dto.request.UsuarioCreateRequestDto;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.UsuarioLoginListResponse;
import br.com.fiap.ecoswitch.ecoswitch.exception.BadRequestException;
import br.com.fiap.ecoswitch.ecoswitch.security.model.UsuarioLogin;
import br.com.fiap.ecoswitch.ecoswitch.security.repository.UsuarioLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static br.com.fiap.ecoswitch.ecoswitch.exception.KeyMessageError.USUARIO_JA_CADASTRADO;

@Service
public class UsuarioLoginService {

    @Autowired
    private UsuarioLoginRepository repository;

    public UsuarioLoginListResponse salvar(final UsuarioCreateRequestDto request) {
        this.validaSeUsuarioEstaCadastrado(request.usuario(), request.email());
        final UsuarioLogin usuarioSalvo = repository.save(toModel(request));

        return UsuarioLoginListResponse.builder()
                .usuario(usuarioSalvo.getUsuario())
                .email(usuarioSalvo.getEmail())
                .role(usuarioSalvo.getRole()).build();
    }

    private void validaSeUsuarioEstaCadastrado(final String usuario, final String email) {
        if(repository.findByUsuarioOrEmail(usuario, email).isPresent()) {
            throw new BadRequestException(USUARIO_JA_CADASTRADO.getMessage());
        }
    }

    private static UsuarioLogin toModel(final UsuarioCreateRequestDto request) {
        final String senhaCriptografada = new BCryptPasswordEncoder().encode(request.senha());
        UsuarioLogin usuarioLogin = new UsuarioLogin();

        usuarioLogin.setUsuario(request.usuario());
        usuarioLogin.setEmail(request.email());
        usuarioLogin.setSenha(senhaCriptografada);
        usuarioLogin.setRole(request.role());

        return usuarioLogin;
    }

}
