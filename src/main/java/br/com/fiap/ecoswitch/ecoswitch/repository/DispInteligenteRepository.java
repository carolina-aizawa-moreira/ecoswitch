package br.com.fiap.ecoswitch.ecoswitch.repository;

import br.com.fiap.ecoswitch.ecoswitch.model.DispositivoInteligente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DispInteligenteRepository extends MongoRepository<DispositivoInteligente, Long> {
}
