package br.com.fiap.ecoswitch.ecoswitch.dto.request;

import br.com.fiap.ecoswitch.ecoswitch.commons.Acao;
import br.com.fiap.ecoswitch.ecoswitch.commons.DiasSemana;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public record AgendamentoProgramadoRequestDTO(
        @NotNull(message = "O ID do dispositivo inteligente é obrigatório")
        String dispositivoInteligenteId,

        @NotNull(message = "A data do agendamento é obrigatória")
        LocalDate data,

        @NotNull(message = "A hora do agendamento é obrigatória")
        LocalTime hora,

        Set<DiasSemana> diasDaSemana, // IDs dos dias da semana (opcional)

        @NotNull(message = "A ação do agendamento é obrigatória")
        Acao acao,

        @NotNull(message = "O status 'ativo' é obrigatório")
        Boolean ativo,

        @NotNull(message = "O campo 'repetirAgendamento' é obrigatório")
        Boolean repetirAgendamento
) {
}
