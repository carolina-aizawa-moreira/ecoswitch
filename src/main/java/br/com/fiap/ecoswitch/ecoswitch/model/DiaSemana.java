package br.com.fiap.ecoswitch.ecoswitch.model;

import br.com.fiap.ecoswitch.ecoswitch.commons.DiasSemana;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_dia_semana")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiaSemana {
    private final static String SEQ_NAME = "SEQ_DIA_SEMANA";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agend_programado_id")
    private AgendamentoProgramado agendamentoProgramado;

    @Column(name = "dia_da_semana")
    @Enumerated(EnumType.STRING)
    private DiasSemana diasSemana;
}
