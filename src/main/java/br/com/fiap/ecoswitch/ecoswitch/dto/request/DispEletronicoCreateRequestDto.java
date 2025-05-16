package br.com.fiap.ecoswitch.ecoswitch.dto.request;

import br.com.fiap.ecoswitch.ecoswitch.commons.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Jacksonized
@Builder
public record DispEletronicoCreateRequestDto(
        @NotBlank(message = "Nome do produto obrigatório")
        String nomeProduto,

        @NotBlank(message = "Nome da marca obrigatório")
        String marca,

        @NotNull(message = "Tipo do dispositivo obrigatório")
        TipoDispositivo tipoDispositivo,

        @NotNull(message = "Tensão de entrada obrigatório")
        Number tensaoEntrada,

        @NotNull(message = "Consumo de energia obrigatório")
        Number consumoEnergia,

        @NotNull(message = "Corrente de entrada obrigatório")
        Number correnteEntrada,

        @NotNull(message = "Frequencia obrigaória")
        Number frequencia,

        @NotNull(message = "Tipo de conector obrigatório")
        TipoConector tipoConector,

        @NotNull(message = "Peso obrigatório")
        Number peso,

        @NotNull
        ClassificacaoEficienciaEnergetica classificacaoEficienciaEnergetica,

        @NotNull(message = "data de fabricação obrigatório")
        LocalDate dataFabricacao,

        @NotNull
        Boolean possuiConversorDc,

        @NotNull
        Boolean ativo,

        // Campos do DispositivoInteligente
        @NotNull(message = "Status do rele é obrigatório")
                Boolean statusRele,

        @NotNull(message = "Medição de energia é obrigatória")
        Number medicaoEnergia,

        @NotNull(message = "Limite de corrente é obrigatório")
        Number limiteCorrente,

        @NotNull(message = "Conectividade é obrigatória")
        Conectividade conectividade,

        @NotNull(message = "Status de conexão é obrigatório")
        StatusConexao statusConexao,

        @NotNull(message = "Protocolo de compatibilidade é obrigatório")
        ProtocoloCompatibilidade protocoloCompatibilidade,

        @NotNull(message = "Sensor de temperatura é obrigatório")
        Number sensorTemperatura,

        @NotNull(message = "Bloqueio manual é obrigatório")
        Boolean bloqueioManual
) {
}
