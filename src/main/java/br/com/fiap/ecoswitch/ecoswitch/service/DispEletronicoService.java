package br.com.fiap.ecoswitch.ecoswitch.service;

import br.com.fiap.ecoswitch.ecoswitch.dto.request.DispEletronicoCreateRequestDto;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.DispEletronicoCreateResponseDto;
import br.com.fiap.ecoswitch.ecoswitch.model.DispositivoEletronico;
import br.com.fiap.ecoswitch.ecoswitch.repository.DispEletronicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DispEletronicoService {

    private DispEletronicoRepository repository;

    public DispEletronicoCreateResponseDto create(final DispEletronicoCreateRequestDto request) {
        DispositivoEletronico dispEletronico = new DispositivoEletronico();
        BeanUtils.copyProperties(request, dispEletronico);
        final DispositivoEletronico saved = repository.save(dispEletronico);

        DispEletronicoCreateResponseDto response = new DispEletronicoCreateResponseDto(
                saved.getId(), saved.getNomeProduto(), saved.getMarca(), saved.getTipoDispositivo(), saved.getTensaoEntrada(),
                saved.getConsumoEnergia(), saved.getCorrenteEntrada(), saved.getFrequencia(), saved.getTipoConector(), saved.getPeso(), saved.getClassificacaoEficienciaEnergetica(), saved.getDataFabricacao(), saved.getPossuiConversorDc(), saved.getAtivo()
        );

        return response;
    }
}
