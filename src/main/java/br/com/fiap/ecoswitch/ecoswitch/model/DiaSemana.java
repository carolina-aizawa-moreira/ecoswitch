package br.com.fiap.ecoswitch.ecoswitch.model;

import br.com.fiap.ecoswitch.ecoswitch.commons.DiasSemana;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "tb_dia_semana")
@Getter
public class DiaSemana {
    private final static String SEQ_NAME = "SEQ_DIA_SEMANA";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agend_programado_id")
    private AgendamentoProgramado agendamentoProgramado;

    @Column(name = "dia_da_semana")
    @Enumerated(EnumType.STRING)
    private DiasSemana diasSemana;
}
