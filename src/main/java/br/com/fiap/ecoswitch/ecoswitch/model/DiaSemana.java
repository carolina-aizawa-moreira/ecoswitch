package br.com.fiap.ecoswitch.ecoswitch.model;

import br.com.fiap.ecoswitch.ecoswitch.commons.DiasSemana;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiaSemana {

    @Id
    private Long id;

    private AgendamentoProgramado agendamentoProgramado;

    @Enumerated(EnumType.STRING)
    private DiasSemana diasSemana;
}
