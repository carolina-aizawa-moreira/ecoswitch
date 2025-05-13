package br.com.fiap.ecoswitch.ecoswitch.service;

import br.com.fiap.ecoswitch.ecoswitch.dto.request.DispEletronicoCreateRequestDto;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.DispEletronicoCreateResponseDto;
import br.com.fiap.ecoswitch.ecoswitch.model.DispositivoEletronico;
import br.com.fiap.ecoswitch.ecoswitch.repository.DispEletronicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class DispEletronicoService {

    @Autowired
    private DispEletronicoRepository repository;

    public DispEletronicoCreateResponseDto create(final DispEletronicoCreateRequestDto request) {

        if (repository.existsByNomeProdutoAndMarca(request.nomeProduto(), request.marca())) {
            throw new IllegalArgumentException("Dispositivo já existe");
        }

        DispositivoEletronico dispEletronico = new DispositivoEletronico();
        BeanUtils.copyProperties(request, dispEletronico);
        final DispositivoEletronico saved = repository.save(dispEletronico);


        DispEletronicoCreateResponseDto response = new DispEletronicoCreateResponseDto(
                saved.getId(), saved.getNomeProduto(), saved.getMarca(), saved.getTipoDispositivo(), saved.getTensaoEntrada(),
                saved.getConsumoEnergia(), saved.getCorrenteEntrada(), saved.getFrequencia(), saved.getTipoConector(), saved.getPeso(), saved.getClassificacaoEficienciaEnergetica(), saved.getDataFabricacao(), saved.getPossuiConversorDc(), saved.getAtivo()
        );

        return response;
    }

    public Page<DispEletronicoCreateResponseDto> list(@PageableDefault(size = 10, sort = "marca") Pageable page){
        return repository.findAll(page).map(DispEletronicoCreateResponseDto::new);
    }
}
