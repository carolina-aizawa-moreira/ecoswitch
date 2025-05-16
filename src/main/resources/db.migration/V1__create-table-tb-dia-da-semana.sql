CREATE TABLE `tb_dia_semana`
(
    id                  INTEGER DEFAULT TB_DISPOSITIVO_ELETRONICO_SEQ.NEXTVAL NOT NULL,
    agend_programado_id INTEGER,
    dia_da_semana       VARCHAR2(30),
    CONSTRAINT FK_agendamento_programado FOREIGN KEY (agend_programado_id) REFERENCES tb_agendamento_programado (id)
);

CREATE TABLE `tb_agendamento_programado`
(
    id                  INTEGER DEFAULT TB_AGENDAMENTO_PROGRAMADO_SEQ.NEXTVAL NOT NULL,
    disp_inteligente_id INTEGER,
    data                DATE      NOT NULL,
    hora                TIMESTAMP NOT NULL,
    acao                VARCHAR2(50) NULL,
    ativo               BOOLEAN   NOT NULL DEFAULT FALSE,
    repetir_agendamento BOOLEAN   NOT NULL DEFAULT FALSE,
    CONSTRAINT FK_disp_inteligente FOREIGN KEY (disp_inteligente_id) REFERENCES tb_dispositivo_inteligente (id)
);

CREATE TABLE `tb_dispositivo_inteligente`
(
    id                        INTEGER DEFAULT TB_DISPOSITIVO_INTELIGENTE_SEQ.NEXTVAL NOT NULL,
    agendamento_id            INTEGER,
    status_rele               BOOLEAN,
    medicao_energia           NUMBER NULL,
    limite_corrente           NUMBER NULL,
    conectividade             VARCHAR2(255) NOT NULL,
    status_conexao            VARCHAR2(255) NOT NULL DEFAULT 'OFFLINE',
    protocolo_compatibilidade VARCHAR2(255) NULL,
    sensor_temperatura        NUMBER NULL,
    bloqueio_manual           BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT FK_agendamento FOREIGN KEY (agendamento_id) REFERENCES tb_agendamento_programado (id)
);

CREATE TABLE tb_dispositivo_eletronico
(
    id                   INTEGER DEFAULT TB_DISPOSITIVO_ELETRONICO_SEQ.NEXTVAL NOT NULL,
    disp_inteligente_id  INTEGER,
    nome_produto         VARCHAR2(255),
    marca                VARCHAR2(255),
    tipo_dispositivo     VARCHAR2(50),
    tensao_entrada       NUMBER,
    consumo_energia      NUMBER,
    corrente_entrada     NUMBER,
    frequencia           NUMBER,
    tipo_conector        VARCHAR2(50),
    peso                 NUMBER,
    clas_efic_energetica VARCHAR2(50),
    data_fabricacao      DATE,
    num_serie            VARCHAR2(255),
    possui_conversor_dc  CHAR(1),
    ativo                CHAR(1),
    CONSTRAINT fk_disp_inteligente
        FOREIGN KEY (disp_inteligente_id)
            REFERENCES tb_dispositivo_inteligente (id)
);

