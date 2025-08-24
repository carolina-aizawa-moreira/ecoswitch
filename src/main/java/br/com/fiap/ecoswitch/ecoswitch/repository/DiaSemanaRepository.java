package br.com.fiap.ecoswitch.ecoswitch.repository;

import br.com.fiap.ecoswitch.ecoswitch.model.DiaSemana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiaSemanaRepository extends MongoRepository<DiaSemana, Long> {
}
