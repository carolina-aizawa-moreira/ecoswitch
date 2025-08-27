package br.com.fiap.ecoswitch.ecoswitch.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Builder
public class Auditoria {
    @Id
    private String id;
    private String className;
    private String user;
    private String action;
    private LocalDateTime registedDate;
}
