package br.com.fiap.ecoswitch.ecoswitch.model;

import br.com.fiap.ecoswitch.ecoswitch.commons.ClassificacaoEficienciaEnergetica;
import br.com.fiap.ecoswitch.ecoswitch.commons.TipoConector;
import br.com.fiap.ecoswitch.ecoswitch.commons.TipoDispositivo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DispositivoEletronico {

    @Id
    private String id;

    private DispositivoInteligente dispositivoInteligente;

    private String nomeProduto;

    private String marca;

    private TipoDispositivo tipoDispositivo;

    private Number tensaoEntrada;

    private Number consumoEnergia;

    private Number correnteEntrada;

    private Number frequencia;

    private TipoConector tipoConector;

    private Number peso;

    private ClassificacaoEficienciaEnergetica classificacaoEficienciaEnergetica;

    private LocalDate dataFabricacao;

    private String numeroSerie;

    private Boolean possuiConversorDc = false;

    private Boolean ativo = false;


}
