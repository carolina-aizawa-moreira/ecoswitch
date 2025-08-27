package br.com.fiap.ecoswitch.ecoswitch.repository;

import br.com.fiap.ecoswitch.ecoswitch.model.AgendamentoProgramado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgendamentoProgramadoRepository extends MongoRepository<AgendamentoProgramado, String> {
}
