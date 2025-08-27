package br.com.fiap.ecoswitch.ecoswitch.service;

import br.com.fiap.ecoswitch.ecoswitch.dto.request.AgendamentoProgramadoRequestDTO;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.AgendamentoProgramadoResponseDTO;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.AgendamentoProgramadoUpdateDTO;
import br.com.fiap.ecoswitch.ecoswitch.exception.BadRequestException;
import br.com.fiap.ecoswitch.ecoswitch.model.AgendamentoProgramado;
import br.com.fiap.ecoswitch.ecoswitch.model.DispositivoInteligente;
import br.com.fiap.ecoswitch.ecoswitch.repository.AgendamentoProgramadoRepository;
import br.com.fiap.ecoswitch.ecoswitch.repository.DispInteligenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AgendamentoProgramadoService {

    @Autowired
    private  AgendamentoProgramadoRepository agendamentoRepository;

    @Autowired
    private  DispInteligenteRepository dispositivoRepository;

    @Transactional
    public AgendamentoProgramadoResponseDTO criarAgendamento(AgendamentoProgramadoRequestDTO dto) {
        DispositivoInteligente dispositivo = dispositivoRepository.findById(dto.dispositivoInteligenteId())
                .orElseThrow(() -> new BadRequestException("Dispositivo não encontrado"));

        AgendamentoProgramado agendamento = new AgendamentoProgramado();
        agendamento.setDispositivoInteligente(dispositivo);
        agendamento.setData(dto.data());
        agendamento.setHora(dto.hora());
        agendamento.setAcao(dto.acao());
        agendamento.setAtivo(dto.ativo());
        agendamento.addDiasSemana(dto.diasDaSemana());
        agendamento.setRepetirAgendamento(dto.repetirAgendamento());

        AgendamentoProgramado saved = agendamentoRepository.save(agendamento);

        return toResponseDTO(saved);
    }

    private AgendamentoProgramadoResponseDTO toResponseDTO(AgendamentoProgramado agendamento) {

        return new AgendamentoProgramadoResponseDTO(
                agendamento.getId(),
                agendamento.getDispositivoInteligente().getId(),
                agendamento.getData(),
                agendamento.getHora(),
                agendamento.getDiasSemana(),
                agendamento.getAcao(),
                agendamento.getAtivo(),
                agendamento.getRepetirAgendamento()
        );
    }

    @Transactional
    public AgendamentoProgramadoResponseDTO atualizarAgendamento(String id, AgendamentoProgramadoUpdateDTO dto) {
        AgendamentoProgramado agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Agendamento não encontrado"));

        if (dto.data() != null) agendamento.setData(dto.data());
        if (dto.hora() != null) agendamento.setHora(dto.hora());
        if (dto.acao() != null) agendamento.setAcao(dto.acao());
        if (dto.ativo() != null) agendamento.setAtivo(dto.ativo());
        if(Optional.ofNullable(dto.diasDaSemana()).isPresent()) agendamento.setDiasSemana(dto.diasDaSemana());
        if (dto.repetirAgendamento() != null) agendamento.setRepetirAgendamento(dto.repetirAgendamento());

        AgendamentoProgramado updated = agendamentoRepository.save(agendamento);
        return toResponseDTO(updated);
    }

    @Transactional
    public void desativarAgendamento(String id) {
        AgendamentoProgramado agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Agendamento não encontrado"));
        agendamento.setAtivo(false);
        agendamentoRepository.save(agendamento);
    }

    @Transactional
    public void excluirAgendamentoPermanentemente(String id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new BadRequestException("Agendamento não encontrado");
        }
        agendamentoRepository.deleteById(id);
    }


}
