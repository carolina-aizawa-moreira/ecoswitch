package br.com.fiap.ecoswitch.ecoswitch.security.controller;

import br.com.fiap.ecoswitch.ecoswitch.dto.request.LoginRequestDto;
import br.com.fiap.ecoswitch.ecoswitch.dto.request.UsuarioCreateRequestDto;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.TokenResponseDto;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.UsuarioLoginListResponse;
import br.com.fiap.ecoswitch.ecoswitch.security.model.UsuarioLogin;
import br.com.fiap.ecoswitch.ecoswitch.security.service.UsuarioLoginService;
import br.com.fiap.ecoswitch.ecoswitch.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    //gerenciador de autenticacao
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioLoginService usuarioLoginService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody @Valid final LoginRequestDto request)  {
        final UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(request.email(), request.senha());

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((UsuarioLogin) auth.getPrincipal());

        return ResponseEntity.ok(new TokenResponseDto(token));

    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioLoginListResponse> registrar(@RequestBody @Valid final UsuarioCreateRequestDto request) {
        final UsuarioLoginListResponse usuarioSalvo = usuarioLoginService.salvar(request);

        return ResponseEntity.ok().body(usuarioSalvo);
    }

}
