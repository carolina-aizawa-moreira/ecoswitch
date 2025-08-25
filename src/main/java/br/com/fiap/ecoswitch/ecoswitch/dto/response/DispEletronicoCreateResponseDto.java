package br.com.fiap.ecoswitch.ecoswitch.dto.response;

import br.com.fiap.ecoswitch.ecoswitch.commons.ClassificacaoEficienciaEnergetica;
import br.com.fiap.ecoswitch.ecoswitch.commons.TipoConector;
import br.com.fiap.ecoswitch.ecoswitch.commons.TipoDispositivo;
import br.com.fiap.ecoswitch.ecoswitch.model.DispositivoEletronico;
import br.com.fiap.ecoswitch.ecoswitch.model.DispositivoInteligente;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Jacksonized
@Builder
public record DispEletronicoCreateResponseDto(String id,
                                              String nomeProduto,
                                              String marca,
                                              TipoDispositivo tipoDispositivo,
                                              Number tensaoEntrada,
                                              Number consumoEnergia,
                                              Number correnteEntrada,
                                              Number frequencia,
                                              TipoConector tipoConector,
                                              Number peso,
                                              ClassificacaoEficienciaEnergetica classificacaoEficienciaEnergetica,
                                              LocalDate dataFabricacao,
                                              Boolean possuiConversorDc,
                                              Boolean ativo,
                                              // Dados do Dispositivo Inteligente
                                              Boolean statusRele,
                                              Number medicaoEnergia,
                                              Number limiteCorrente,
                                              String conectividade,
                                              String statusConexao,
                                              String protocoloCompatibilidade,
                                              Number sensorTemperatura,
                                              Boolean bloqueioManual
                                            ) {

    public DispEletronicoCreateResponseDto(DispositivoEletronico eletronico, DispositivoInteligente inteligente){
        this(
                eletronico.getId(),
                eletronico.getNomeProduto(),
                eletronico.getMarca(),
                eletronico.getTipoDispositivo(),
                eletronico.getTensaoEntrada(),
                eletronico.getConsumoEnergia(),
                eletronico.getCorrenteEntrada(),
                eletronico.getFrequencia(),
                eletronico.getTipoConector(),
                eletronico.getPeso(),
                eletronico.getClassificacaoEficienciaEnergetica(),
                eletronico.getDataFabricacao(),
                eletronico.getPossuiConversorDc(),
                eletronico.getAtivo(),

                (inteligente != null) ? inteligente.getStatusRele() : null,
                (inteligente != null) ? inteligente.getMedicaoEnergia() : null,
                (inteligente != null) ? inteligente.getLimiteCorrente() : null,
                (inteligente != null && inteligente.getConectividade() != null) ? inteligente.getConectividade().name() : null,
                (inteligente != null && inteligente.getStatusConexao() != null) ? inteligente.getStatusConexao().name() : null,
                (inteligente != null && inteligente.getProtocoloCompatibilidade() != null) ? inteligente.getProtocoloCompatibilidade().name() : null,
                (inteligente != null) ? inteligente.getSensorTemperatura() : null,
                (inteligente != null) ? inteligente.getBloqueioManual() : null
        );
    }


}
