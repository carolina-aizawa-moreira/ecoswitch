package br.com.fiap.ecoswitch.ecoswitch.model;

import br.com.fiap.ecoswitch.ecoswitch.commons.ClassificacaoEficienciaEnergetica;
import br.com.fiap.ecoswitch.ecoswitch.commons.TipoConector;
import br.com.fiap.ecoswitch.ecoswitch.commons.TipoDispositivo;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_dispositivo_eletronico")
@Getter
public class DispositivoEletronico {
    private static final String SEQ_NAME = "SEQ_DISPOSITIVO_ELETRONICO";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME)
    private Long id;

    @OneToOne
    @JoinColumn(name = "disp_inteligente_id")
    private DispositivoInteligente dispositivoInteligente;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "marca")
    private String marca;

    @Column(name = "tipo_dispositivo")
    @Enumerated(EnumType.STRING)
    private TipoDispositivo tipoDispositivo;

    @Column(name = "tensao_entrada")
    private Number tensaoEntrada;

    @Column(name = "consumo_energia")
    private Number consumoEnergia;

    @Column(name = "corrente_entrada")
    private Number correnteEntrada;

    @Column(name = "frequencia")
    private Number frequencia;

    @Column(name = "tipo_conector")
    @Enumerated(EnumType.STRING)
    private TipoConector tipoConector;

    @Column(name = "peso")
    private Number peso;

    @Column(name = "clas_efic_energetica")
    @Enumerated(EnumType.STRING)
    private ClassificacaoEficienciaEnergetica classificacaoEficienciaEnergetica;

    @Column(name = "data_fabricacao")
    private LocalDate dataFabricacao;

    @Column(name = "num_serie")
    private String numeroSerie;

    @Column(name = "possui_conversor_dc")
    private Boolean possuiConversorDc;

    @Column(name = "ativo")
    private Boolean ativo;

}
