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
@Table(name = "tb_dispositivo_inteligente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DispositivoInteligente {
    private final static String SEQ_NAME = "SEQ_DISP_INTELIGENTE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @OneToMany
    @JoinColumn(name = "agendamento_id")
    private List<AgendamentoProgramado> agendamentos;

    @Column(name = "status_rele")
    private Boolean statusRele;

    @Column(name = "medicao_energia")
    private Number medicaoEnergia;

    @Column(name = "limite_corrente")
    private Number limiteCorrente;

    @Column(name = "conectividade")
    @Enumerated(EnumType.STRING)
    private Conectividade conectividade;

    @Column(name = "status_conexao")
    @Enumerated(EnumType.STRING)
    private StatusConexao statusConexao;

    @Column(name = "protocolo_compatibilidade")
    @Enumerated(EnumType.STRING)
    private ProtocoloCompatibilidade protocoloCompatibilidade;

    @Column(name = "sensor_temperatura")
    private Number sensorTemperatura;

    @Column(name = "bloqueio_manual")
    private Boolean bloqueioManual;



}
