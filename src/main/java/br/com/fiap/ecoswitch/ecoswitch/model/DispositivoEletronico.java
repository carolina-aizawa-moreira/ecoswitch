package br.com.fiap.ecoswitch.ecoswitch.model;

import br.com.fiap.ecoswitch.ecoswitch.commons.ClassificacaoEficienciaEnergetica;
import br.com.fiap.ecoswitch.ecoswitch.commons.TipoConector;
import br.com.fiap.ecoswitch.ecoswitch.commons.TipoDispositivo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DispositivoEletronico {

    @Id
    private Long id;

    private DispositivoInteligente dispositivoInteligente;

    private String nomeProduto;

    private String marca;

    @Enumerated(EnumType.STRING)
    private TipoDispositivo tipoDispositivo;

    private Number tensaoEntrada;

    private Number consumoEnergia;

    private Number correnteEntrada;

    private Number frequencia;

    private TipoConector tipoConector;

    private Number peso;

    @Column(name = "clas_efic_energetica")
    @Enumerated(EnumType.STRING)
    private ClassificacaoEficienciaEnergetica classificacaoEficienciaEnergetica;

    private LocalDate dataFabricacao;

    private String numeroSerie;

    private Boolean possuiConversorDc = false;

    private Boolean ativo = false;


}
