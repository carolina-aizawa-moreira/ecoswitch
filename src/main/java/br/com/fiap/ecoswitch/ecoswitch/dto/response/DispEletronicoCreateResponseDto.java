package br.com.fiap.ecoswitch.ecoswitch.dto.response;

import br.com.fiap.ecoswitch.ecoswitch.commons.ClassificacaoEficienciaEnergetica;
import br.com.fiap.ecoswitch.ecoswitch.commons.TipoConector;
import br.com.fiap.ecoswitch.ecoswitch.commons.TipoDispositivo;
import br.com.fiap.ecoswitch.ecoswitch.model.DispositivoEletronico;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Jacksonized
@Builder
public record DispEletronicoCreateResponseDto(Long id,
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
                                              Boolean ativo) {

    public DispEletronicoCreateResponseDto(DispositivoEletronico eletronico){
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
                eletronico.getAtivo());
    }
}
