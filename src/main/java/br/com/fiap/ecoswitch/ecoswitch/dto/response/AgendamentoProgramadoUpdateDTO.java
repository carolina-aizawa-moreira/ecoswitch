package br.com.fiap.ecoswitch.ecoswitch.dto.response;

import br.com.fiap.ecoswitch.ecoswitch.commons.Acao;
import br.com.fiap.ecoswitch.ecoswitch.commons.DiasSemana;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public record AgendamentoProgramadoUpdateDTO(
        String id,
        LocalDate data,
        LocalTime hora,
        Set<DiasSemana> diasDaSemana,
        Acao acao,
        Boolean ativo,
        Boolean repetirAgendamento
) {
}
