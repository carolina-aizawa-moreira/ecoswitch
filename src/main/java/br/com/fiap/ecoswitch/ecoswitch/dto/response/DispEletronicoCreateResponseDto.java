package br.com.fiap.ecoswitch.ecoswitch.dto.response;

import br.com.fiap.ecoswitch.ecoswitch.commons.ClassificacaoEficienciaEnergetica;
import br.com.fiap.ecoswitch.ecoswitch.commons.TipoConector;
import br.com.fiap.ecoswitch.ecoswitch.commons.TipoDispositivo;
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
                                              boolean possuiConversorDc,
                                              boolean ativo) {
}
