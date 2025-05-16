package br.com.fiap.ecoswitch.ecoswitch.dto.request;

import br.com.fiap.ecoswitch.ecoswitch.commons.Conectividade;
import br.com.fiap.ecoswitch.ecoswitch.commons.ProtocoloCompatibilidade;
import br.com.fiap.ecoswitch.ecoswitch.commons.StatusConexao;
import br.com.fiap.ecoswitch.ecoswitch.model.AgendamentoProgramado;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DispInteligenteCreateRequestDto(

        List<AgendamentoProgramado> agendamentos,

        @NotNull(message = "O campo 'statusRele' não pode ser nulo.")
        Boolean statusRele,

        @NotNull(message = "O campo 'medicaoEnergia' não pode ser nulo.")
        @DecimalMin(value = "0.0", inclusive = false, message = "O valor de 'medicaoEnergia' deve ser maior que zero.")
        Number medicaoEnergia,

        @NotNull(message = "O campo 'limiteCorrente' não pode ser nulo.")
        @DecimalMin(value = "0.0", inclusive = false, message = "O valor de 'limiteCorrente' deve ser maior que zero.")
        Number limiteCorrente,

        @NotNull(message = "O campo 'conectividade' não pode ser nulo.")
        Conectividade conectividade,

        @NotNull(message = "O campo 'statusConexao' não pode ser nulo.")
        StatusConexao statusConexao,

        @NotNull(message = "O campo 'protocoloCompatibilidade' não pode ser nulo.")
        ProtocoloCompatibilidade protocoloCompatibilidade,

        @NotNull(message = "O campo 'sensorTemperatura' não pode ser nulo.")
        @DecimalMin(value = "0.0", inclusive = false, message = "O valor de 'sensorTemperatura' deve ser maior que zero.")
        Number sensorTemperatura,

        @NotNull(message = "O campo 'bloqueioManual' não pode ser nulo.")
        Boolean bloqueioManual
) {
}
