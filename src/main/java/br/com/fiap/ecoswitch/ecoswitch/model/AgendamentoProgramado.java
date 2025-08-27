package br.com.fiap.ecoswitch.ecoswitch.model;

import br.com.fiap.ecoswitch.ecoswitch.commons.Acao;
import br.com.fiap.ecoswitch.ecoswitch.commons.DiasSemana;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoProgramado {

    @Id
    private String id;

    private DispositivoInteligente dispositivoInteligente;

    private LocalDate data;

    private LocalTime hora;

    private Set<DiasSemana> diasSemana = new HashSet<>();

    private Acao acao;

    private Boolean ativo;

    private Boolean repetirAgendamento;

    public void addDiasSemana(List<DiasSemana> diasSemanas) {
        this.diasSemana.addAll(diasSemanas);
    }
}
