package br.com.fiap.ecoswitch.ecoswitch.controller;

import br.com.fiap.ecoswitch.ecoswitch.dto.request.DispEletronicoCreateRequestDto;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.DispEletronicoCreateResponseDto;
import br.com.fiap.ecoswitch.ecoswitch.service.DispEletronicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dispositivos-eletronicos")
public class DispositivoEletronicoController {

    private DispEletronicoService service;

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("CONEXAO FEITA COM SUCESSO");
    }

    @PostMapping
    public ResponseEntity<DispEletronicoCreateResponseDto> create(@RequestBody @Valid DispEletronicoCreateRequestDto createRequest) {
        final DispEletronicoCreateResponseDto response = service.create(createRequest);
        return ResponseEntity.ok().body(response);
    }
}
