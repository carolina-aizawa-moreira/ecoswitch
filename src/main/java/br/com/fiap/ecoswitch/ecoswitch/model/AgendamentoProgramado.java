package br.com.fiap.ecoswitch.ecoswitch.model;

import br.com.fiap.ecoswitch.ecoswitch.commons.Acao;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "tb_agendamento_programado")
@Getter
public class AgendamentoProgramado {

    private final static String SEQ_NAME = "SEQ_AGEND_PROGRAMADO";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "disp_inteligente_id")
    private DispositivoInteligente dispositivoInteligente;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "hora")
    private LocalTime hora;

    @OneToMany
    @JoinColumn(name = "dias_semana_id")
    private Set<DiaSemana> diasSemana;

    @Column(name = "acao")
    private Acao acao;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "repetir_agendamento")
    private Boolean repetirAgendamento;
}
