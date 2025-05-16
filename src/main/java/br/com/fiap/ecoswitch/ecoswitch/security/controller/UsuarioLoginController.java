package br.com.fiap.ecoswitch.ecoswitch.security.controller;

import br.com.fiap.ecoswitch.ecoswitch.security.service.AuthorizationService;
import br.com.fiap.ecoswitch.ecoswitch.security.service.UsuarioLoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario-login")
public class UsuarioLoginController {
    private AuthorizationService authorizationService;

    private UsuarioLoginService usuarioLoginService;


}
