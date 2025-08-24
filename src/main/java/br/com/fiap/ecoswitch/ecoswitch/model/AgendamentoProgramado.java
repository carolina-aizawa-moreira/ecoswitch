package br.com.fiap.ecoswitch.ecoswitch.model;

import br.com.fiap.ecoswitch.ecoswitch.commons.Acao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoProgramado {

    @Id
    private Long id;

    private DispositivoInteligente dispositivoInteligente;

    private LocalDate data;

    private LocalTime hora;

    private Set<DiaSemana> diasSemana;

    @Enumerated(EnumType.STRING)
    private Acao acao;

    private Boolean ativo;

    private Boolean repetirAgendamento;
}
