package br.com.fiap.ecoswitch.ecoswitch.dto.response;

import br.com.fiap.ecoswitch.ecoswitch.commons.Acao;
import br.com.fiap.ecoswitch.ecoswitch.commons.DiasSemana;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public record AgendamentoProgramadoResponseDTO(
        String id,
        String dispositivoInteligenteId,
        LocalDate data,
        LocalTime hora,
        Set<DiasSemana> diasSemanas,
        Acao acao,
        Boolean ativo,
        Boolean repetirAgendamento
) {
}
