package br.com.fiap.ecoswitch.ecoswitch.service;

import br.com.fiap.ecoswitch.ecoswitch.dto.request.DispEletronicoCreateRequestDto;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.DispEletronicoCreateResponseDto;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.DispInteligenteCreateResponseDto;
import br.com.fiap.ecoswitch.ecoswitch.model.DispositivoEletronico;
import br.com.fiap.ecoswitch.ecoswitch.model.DispositivoInteligente;
import br.com.fiap.ecoswitch.ecoswitch.repository.DispEletronicoRepository;
import br.com.fiap.ecoswitch.ecoswitch.repository.DispInteligenteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class DispEletronicoService {

    @Autowired
    private DispEletronicoRepository dispEletronicoRepository;

    @Autowired
    private DispInteligenteRepository dispInteligenteRepository;

    public DispEletronicoCreateResponseDto create(final DispEletronicoCreateRequestDto request) {

        if (dispEletronicoRepository.existsByNomeProdutoAndMarca(request.nomeProduto(), request.marca())) {
            throw new IllegalArgumentException("Dispositivo já existe");
        }

        DispositivoInteligente dispositivoInteligente = new DispositivoInteligente();

        dispositivoInteligente.setStatusRele(request.statusRele());
        dispositivoInteligente.setMedicaoEnergia(request.medicaoEnergia());
        dispositivoInteligente.setLimiteCorrente(request.limiteCorrente());
        dispositivoInteligente.setConectividade(request.conectividade());
        dispositivoInteligente.setStatusConexao(request.statusConexao());
        dispositivoInteligente.setProtocoloCompatibilidade(request.protocoloCompatibilidade());
        dispositivoInteligente.setSensorTemperatura(request.sensorTemperatura());
        dispositivoInteligente.setBloqueioManual(request.bloqueioManual());

        DispositivoInteligente savedDispositivoInteligente = dispInteligenteRepository.save(dispositivoInteligente);


        DispositivoEletronico dispEletronico = new DispositivoEletronico();
        BeanUtils.copyProperties(request, dispEletronico);
        final DispositivoEletronico saved = dispEletronicoRepository.save(dispEletronico);


        DispEletronicoCreateResponseDto response = new DispEletronicoCreateResponseDto(
                saved.getId(), saved.getNomeProduto(), saved.getMarca(), saved.getTipoDispositivo(), saved.getTensaoEntrada(),
                saved.getConsumoEnergia(), saved.getCorrenteEntrada(), saved.getFrequencia(), saved.getTipoConector(), saved.getPeso(), saved.getClassificacaoEficienciaEnergetica(), saved.getDataFabricacao(), saved.getPossuiConversorDc(), saved.getAtivo(),
                dispositivoInteligente.getStatusRele(), dispositivoInteligente.getMedicaoEnergia(),
                dispositivoInteligente.getLimiteCorrente(), dispositivoInteligente.getConectividade().name(),
                dispositivoInteligente.getStatusConexao().name(), dispositivoInteligente.getProtocoloCompatibilidade().name(),
                dispositivoInteligente.getSensorTemperatura(), dispositivoInteligente.getBloqueioManual()

        );

        return response;
    }

    public Page<DispEletronicoCreateResponseDto> list(@PageableDefault(size = 10, sort = "marca") Pageable page) {
        return dispEletronicoRepository.findAll(page).map(disp -> {
            DispositivoInteligente inteligente = disp.getDispositivoInteligente();
            Boolean statusRele = (inteligente != null) ? inteligente.getStatusRele() : null;
            return new DispEletronicoCreateResponseDto(disp, inteligente);
        });
    }


}
