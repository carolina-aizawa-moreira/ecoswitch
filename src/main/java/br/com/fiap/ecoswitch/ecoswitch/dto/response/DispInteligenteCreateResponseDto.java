package br.com.fiap.ecoswitch.ecoswitch.dto.response;

import br.com.fiap.ecoswitch.ecoswitch.commons.Conectividade;
import br.com.fiap.ecoswitch.ecoswitch.commons.ProtocoloCompatibilidade;
import br.com.fiap.ecoswitch.ecoswitch.commons.StatusConexao;
import br.com.fiap.ecoswitch.ecoswitch.model.AgendamentoProgramado;

import java.util.List;

public record DispInteligenteCreateResponseDto(
        String id,
        List<AgendamentoProgramado> agendamentos,
        Boolean statusRele,
        Number medicaoEnergia,
        Number limiteCorrente,
        Conectividade conectividade,
        StatusConexao statusConexao,
        ProtocoloCompatibilidade protocoloCompatibilidade,
        Number sensorTemperatura,
        Boolean bloqueioManual
) {
}
