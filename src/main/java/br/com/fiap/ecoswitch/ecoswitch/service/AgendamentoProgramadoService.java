package br.com.fiap.ecoswitch.ecoswitch.service;

import br.com.fiap.ecoswitch.ecoswitch.commons.Acao;
import br.com.fiap.ecoswitch.ecoswitch.dto.request.AgendamentoProgramadoRequestDTO;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.AgendamentoProgramadoResponseDTO;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.AgendamentoProgramadoUpdateDTO;
import br.com.fiap.ecoswitch.ecoswitch.model.AgendamentoProgramado;
import br.com.fiap.ecoswitch.ecoswitch.model.DiaSemana;
import br.com.fiap.ecoswitch.ecoswitch.model.DispositivoInteligente;
import br.com.fiap.ecoswitch.ecoswitch.repository.AgendamentoProgramadoRepository;
import br.com.fiap.ecoswitch.ecoswitch.repository.DiaSemanaRepository;
import br.com.fiap.ecoswitch.ecoswitch.repository.DispInteligenteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static br.com.fiap.ecoswitch.ecoswitch.model.AgendamentoSpecifications.*;

@Service
public class AgendamentoProgramadoService {

    @Autowired
    private  AgendamentoProgramadoRepository agendamentoRepository;

    @Autowired
    private  DispInteligenteRepository dispositivoRepository;

    @Autowired
    private  DiaSemanaRepository diaSemanaRepository;



    @Transactional
    public AgendamentoProgramadoResponseDTO criarAgendamento(AgendamentoProgramadoRequestDTO dto) {
        DispositivoInteligente dispositivo = dispositivoRepository.findById(dto.dispositivoInteligenteId())
                .orElseThrow(() -> new EntityNotFoundException("Dispositivo não encontrado"));

        AgendamentoProgramado agendamento = new AgendamentoProgramado();
        agendamento.setDispositivoInteligente(dispositivo);
        agendamento.setData(dto.data());
        agendamento.setHora(dto.hora());
        agendamento.setAcao(dto.acao());
        agendamento.setAtivo(dto.ativo());
        agendamento.setRepetirAgendamento(dto.repetirAgendamento());

        if (dto.repetirAgendamento() && dto.diasSemanaIds() != null && !dto.diasSemanaIds().isEmpty()) {
            Set<DiaSemana> diasSemana = dto.diasSemanaIds().stream()
                    .map(id -> diaSemanaRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Dia da semana não encontrado")))
                    .collect(Collectors.toSet());
            agendamento.setDiasSemana(diasSemana);
        }

        AgendamentoProgramado saved = agendamentoRepository.save(agendamento);

        return toResponseDTO(saved);
    }

    private AgendamentoProgramadoResponseDTO toResponseDTO(AgendamentoProgramado agendamento) {
        Set<Long> diasSemanaIds = agendamento.getDiasSemana() != null
                ? agendamento.getDiasSemana().stream().map(DiaSemana::getId).collect(Collectors.toSet())
                : null;

        return new AgendamentoProgramadoResponseDTO(
                agendamento.getId(),
                agendamento.getDispositivoInteligente().getId(),
                agendamento.getData(),
                agendamento.getHora(),
                diasSemanaIds,
                agendamento.getAcao(),
                agendamento.getAtivo(),
                agendamento.getRepetirAgendamento()
        );
    }

    @Transactional
    public AgendamentoProgramadoResponseDTO atualizarAgendamento(Long id, AgendamentoProgramadoUpdateDTO dto) {
        AgendamentoProgramado agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));

        if (dto.data() != null) agendamento.setData(dto.data());
        if (dto.hora() != null) agendamento.setHora(dto.hora());
        if (dto.acao() != null) agendamento.setAcao(dto.acao());
        if (dto.ativo() != null) agendamento.setAtivo(dto.ativo());
        if (dto.repetirAgendamento() != null) agendamento.setRepetirAgendamento(dto.repetirAgendamento());

        if (dto.repetirAgendamento() != null && dto.repetirAgendamento() && dto.diasSemanaIds() != null) {
            Set<DiaSemana> diasSemana = dto.diasSemanaIds().stream()
                    .map(diaId -> diaSemanaRepository.findById(diaId)
                            .orElseThrow(() -> new EntityNotFoundException("Dia da semana não encontrado")))
                    .collect(Collectors.toSet());
            agendamento.setDiasSemana(diasSemana);
        }

        AgendamentoProgramado updated = agendamentoRepository.save(agendamento);
        return toResponseDTO(updated);
    }

    @Transactional
    public void desativarAgendamento(Long id) {
        AgendamentoProgramado agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));
        agendamento.setAtivo(false);
        agendamentoRepository.save(agendamento);
    }

    @Transactional
    public void excluirAgendamentoPermanentemente(Long id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Agendamento não encontrado");
        }
        agendamentoRepository.deleteById(id);
    }


}
