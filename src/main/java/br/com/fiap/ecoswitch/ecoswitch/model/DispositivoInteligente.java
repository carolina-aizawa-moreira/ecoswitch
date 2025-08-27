package br.com.fiap.ecoswitch.ecoswitch.model;

import br.com.fiap.ecoswitch.ecoswitch.commons.Conectividade;
import br.com.fiap.ecoswitch.ecoswitch.commons.ProtocoloCompatibilidade;
import br.com.fiap.ecoswitch.ecoswitch.commons.StatusConexao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DispositivoInteligente {

    @Id
    private String id;

    private List<AgendamentoProgramado> agendamentos;

    private Boolean statusRele;

    private Number medicaoEnergia;

    private Number limiteCorrente;

    private Conectividade conectividade;

    private StatusConexao statusConexao;

    private ProtocoloCompatibilidade protocoloCompatibilidade;

    private Number sensorTemperatura;

    private Boolean bloqueioManual;

}
