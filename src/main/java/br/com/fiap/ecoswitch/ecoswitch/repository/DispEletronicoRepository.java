package br.com.fiap.ecoswitch.ecoswitch.repository;

import br.com.fiap.ecoswitch.ecoswitch.model.DispositivoEletronico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispEletronicoRepository extends MongoRepository<DispositivoEletronico, String> {
    Boolean existsByNomeProdutoAndMarca(String nomeProduto, String marca);

    Boolean existsByNomeProdutoAndMarcaAndIdNot(String nome, String marca, String id);
}
