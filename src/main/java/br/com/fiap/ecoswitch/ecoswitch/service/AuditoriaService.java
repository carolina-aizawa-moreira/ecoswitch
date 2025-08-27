package br.com.fiap.ecoswitch.ecoswitch.service;

import br.com.fiap.ecoswitch.ecoswitch.model.Auditoria;
import br.com.fiap.ecoswitch.ecoswitch.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    public void saveAudit(final String className, final String user, final String action) {
        final Auditoria auditoria = Auditoria.builder()
                .className(className)
                .user(user)
                .action(action)
                .registedDate(LocalDateTime.now()).build();
        auditoriaRepository.save(auditoria);
    }
}
