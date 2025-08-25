package br.com.fiap.ecoswitch.ecoswitch.controller;

import br.com.fiap.ecoswitch.ecoswitch.dto.request.DispEletronicoCreateRequestDto;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.DispEletronicoCreateResponseDto;
import br.com.fiap.ecoswitch.ecoswitch.service.DispEletronicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/dispositivos-eletronicos")
public class DispositivoEletronicoController {

    @Autowired
    private DispEletronicoService service;

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("CONEXAO FEITA COM SUCESSO");
    }

    @PostMapping
    public ResponseEntity<DispEletronicoCreateResponseDto> create(@RequestBody @Valid DispEletronicoCreateRequestDto createRequest, UriComponentsBuilder uriBuilder) {
        final DispEletronicoCreateResponseDto response = service.create(createRequest);
        var uri = uriBuilder.path("/dispositivos-eletronicos/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<DispEletronicoCreateResponseDto>> list(Pageable page){
        var response = service.list(page);
        return ResponseEntity.ok().body(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<DispEletronicoCreateResponseDto> update(
            @PathVariable String id,
            @RequestBody @Valid DispEletronicoCreateRequestDto request) {
        DispEletronicoCreateResponseDto response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
