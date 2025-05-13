package br.com.fiap.ecoswitch.ecoswitch.security.service;

import br.com.fiap.ecoswitch.ecoswitch.dto.request.UsuarioCreateRequestDto;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.UsuarioCreateResponseDto;
import br.com.fiap.ecoswitch.ecoswitch.security.model.UsuarioLogin;
import br.com.fiap.ecoswitch.ecoswitch.security.repository.UsuarioLoginRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UsuarioLoginService {

    private UsuarioLoginRepository repository;

    public UsuarioCreateResponseDto create(final UsuarioCreateRequestDto request) {
        UsuarioLogin usuarioLogin = new UsuarioLogin();
        BeanUtils.copyProperties(request, usuarioLogin);

        final UsuarioLogin usuarioSalvo = repository.save(usuarioLogin);

        UsuarioCreateResponseDto response = UsuarioCreateResponseDto.builder().build();
        BeanUtils.copyProperties(usuarioSalvo, response);

        return response;
    }

}
