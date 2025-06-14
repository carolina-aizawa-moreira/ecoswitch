package br.com.fiap.ecoswitch.ecoswitch.repository;

import br.com.fiap.ecoswitch.ecoswitch.model.DispositivoEletronico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispEletronicoRepository extends JpaRepository<DispositivoEletronico, Long> {
    Boolean existsByNomeProdutoAndMarca(String nomeProduto, String marca);

    Boolean existsByNomeProdutoAndMarcaAndIdNot(String nome, String marca, Long id);
}
