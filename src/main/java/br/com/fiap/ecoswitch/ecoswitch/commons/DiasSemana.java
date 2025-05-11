package br.com.fiap.ecoswitch.ecoswitch.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DiasSemana {
    SEGUNDA_FEIRA("segunda_feira"),
    TERCA_FEIRA("terca_feira"),
    QUARTA_FEIRA("quarta_feira"),
    QUINTA_FEIRA("quinta_feira"),
    SEXTA_FEIRA("sexta_feira"),
    SABADO("sabado"),
    DOMINGO("domingo");

    private String diaSemana;
}
