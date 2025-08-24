package br.com.fiap.ecoswitch.ecoswitch.model;

import br.com.fiap.ecoswitch.ecoswitch.commons.Conectividade;
import br.com.fiap.ecoswitch.ecoswitch.commons.ProtocoloCompatibilidade;
import br.com.fiap.ecoswitch.ecoswitch.commons.StatusConexao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DispositivoInteligente {

    @Id
    private Long id;


    private List<AgendamentoProgramado> agendamentos;

    private Boolean statusRele;

    private Number medicaoEnergia;

    private Number limiteCorrente;

    @Enumerated(EnumType.STRING)
    private Conectividade conectividade;

    @Enumerated(EnumType.STRING)
    private StatusConexao statusConexao;

    @Enumerated(EnumType.STRING)
    private ProtocoloCompatibilidade protocoloCompatibilidade;

    private Number sensorTemperatura;

    private Boolean bloqueioManual;

}
