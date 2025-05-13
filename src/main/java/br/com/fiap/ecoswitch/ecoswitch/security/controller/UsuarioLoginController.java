package br.com.fiap.ecoswitch.ecoswitch.security.controller;

import br.com.fiap.ecoswitch.ecoswitch.dto.request.UsuarioCreateRequestDto;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.UsuarioCreateResponseDto;
import br.com.fiap.ecoswitch.ecoswitch.security.model.UsuarioLogin;
import br.com.fiap.ecoswitch.ecoswitch.security.service.AuthorizationService;
import br.com.fiap.ecoswitch.ecoswitch.security.service.UsuarioLoginService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("usuario-login")
public class UsuarioLoginController {
    private AuthorizationService authorizationService;

    private UsuarioLoginService usuarioLoginService;

    @PostMapping
    public ResponseEntity<UsuarioCreateResponseDto> create (@RequestBody @Valid final UsuarioCreateRequestDto request) {
        final UsuarioCreateResponseDto response = usuarioLoginService.create(request);

        return ResponseEntity.created(URI.create("/usuario-login")).body(response);
    }


}
