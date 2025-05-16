package br.com.fiap.ecoswitch.ecoswitch.model;

import br.com.fiap.ecoswitch.ecoswitch.commons.Acao;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class AgendamentoSpecifications {
    public static Specification<Object> comDispositivoId(Long dispositivoId) {
        return (root, query, cb) ->
                dispositivoId == null ?
                        cb.conjunction() :
                        cb.equal(root.get("dispositivoInteligente").get("id"), dispositivoId);
    }

    public static Specification<Object> comData(LocalDate data) {
        return (root, query, cb) ->
                data == null ?
                        cb.conjunction() :
                        cb.equal(root.get("data"), data);
    }

    public static Specification<Object> comAcao(Acao acao) {
        return (root, query, cb) ->
                acao == null ?
                        cb.conjunction() :
                        cb.equal(root.get("acao"), acao);
    }

    public static Specification<Object> comStatusAtivo(Boolean ativo) {
        return (root, query, cb) ->
                ativo == null ?
                        cb.conjunction() :
                        cb.equal(root.get("ativo"), ativo);
    }
}
