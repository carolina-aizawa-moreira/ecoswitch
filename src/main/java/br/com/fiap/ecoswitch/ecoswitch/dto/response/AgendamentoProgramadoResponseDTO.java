package br.com.fiap.ecoswitch.ecoswitch.dto.response;

import br.com.fiap.ecoswitch.ecoswitch.commons.Acao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public record AgendamentoProgramadoResponseDTO(
        Long id,
        Long dispositivoInteligenteId,
        LocalDate data,
        LocalTime hora,
        Set<Long> diasSemanaIds,
        Acao acao,
        Boolean ativo,
        Boolean repetirAgendamento
) {
}
