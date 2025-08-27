package br.com.fiap.ecoswitch.ecoswitch.controller;

import br.com.fiap.ecoswitch.ecoswitch.dto.request.AgendamentoProgramadoRequestDTO;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.AgendamentoProgramadoResponseDTO;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.AgendamentoProgramadoUpdateDTO;
import br.com.fiap.ecoswitch.ecoswitch.service.AgendamentoProgramadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoProgramadoController {


    @Autowired
    private  AgendamentoProgramadoService agendamentoService;


    @PostMapping("")
    public ResponseEntity<AgendamentoProgramadoResponseDTO> criarAgendamento(
            @Valid @RequestBody AgendamentoProgramadoRequestDTO dto) {
        AgendamentoProgramadoResponseDTO response = agendamentoService.criarAgendamento(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoProgramadoResponseDTO> atualizarAgendamento(
            @PathVariable String id,
            @Valid @RequestBody AgendamentoProgramadoUpdateDTO dto) {
        AgendamentoProgramadoResponseDTO response = agendamentoService.atualizarAgendamento(id, dto);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<Void> desativarAgendamento(@PathVariable String id) {
        agendamentoService.desativarAgendamento(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAgendamentoPermanentemente(@PathVariable String id) {
        agendamentoService.excluirAgendamentoPermanentemente(id);
        return ResponseEntity.noContent().build();
    }
}
