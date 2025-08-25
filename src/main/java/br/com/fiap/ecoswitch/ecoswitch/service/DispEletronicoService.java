package br.com.fiap.ecoswitch.ecoswitch.service;

import br.com.fiap.ecoswitch.ecoswitch.dto.request.DispEletronicoCreateRequestDto;
import br.com.fiap.ecoswitch.ecoswitch.dto.response.DispEletronicoCreateResponseDto;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

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


        return new DispEletronicoCreateResponseDto(
                saved.getId(), saved.getNomeProduto(), saved.getMarca(), saved.getTipoDispositivo(), saved.getTensaoEntrada(),
                saved.getConsumoEnergia(), saved.getCorrenteEntrada(), saved.getFrequencia(), saved.getTipoConector(), saved.getPeso(), saved.getClassificacaoEficienciaEnergetica(), saved.getDataFabricacao(), saved.getPossuiConversorDc(), saved.getAtivo(),
                dispositivoInteligente.getStatusRele(), dispositivoInteligente.getMedicaoEnergia(),
                dispositivoInteligente.getLimiteCorrente(), dispositivoInteligente.getConectividade().name(),
                dispositivoInteligente.getStatusConexao().name(), dispositivoInteligente.getProtocoloCompatibilidade().name(),
                dispositivoInteligente.getSensorTemperatura(), dispositivoInteligente.getBloqueioManual()
        );
    }

    public Page<DispEletronicoCreateResponseDto> list(@PageableDefault(size = 10, sort = "marca") Pageable page) {
        return dispEletronicoRepository.findAll(page).map(disp -> {
            DispositivoInteligente inteligente = disp.getDispositivoInteligente();
            return new DispEletronicoCreateResponseDto(disp, inteligente);
        });
    }

    @Transactional
    public DispEletronicoCreateResponseDto update(String id, DispEletronicoCreateRequestDto request) {
        DispositivoEletronico dispositivoExistente = dispEletronicoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Dispositivo não encontrado com o ID: " + id));

        // Verifica se outro dispositivo com mesmo nome e marca já existe (excluindo o atual)
        if (dispEletronicoRepository.existsByNomeProdutoAndMarcaAndIdNot(
                request.nomeProduto(), request.marca(), id)) {
            throw new IllegalArgumentException("Já existe outro dispositivo com o mesmo nome e marca");
        }

        // Atualiza o dispositivo eletrônico
        BeanUtils.copyProperties(request, dispositivoExistente, "id");

        // Atualiza o dispositivo inteligente associado
        DispositivoInteligente dispositivoInteligente = dispositivoExistente.getDispositivoInteligente();
        if (dispositivoInteligente != null) {
            dispositivoInteligente.setStatusRele(request.statusRele());
            dispositivoInteligente.setMedicaoEnergia(request.medicaoEnergia());
            dispositivoInteligente.setLimiteCorrente(request.limiteCorrente());
            dispositivoInteligente.setConectividade(request.conectividade());
            dispositivoInteligente.setStatusConexao(request.statusConexao());
            dispositivoInteligente.setProtocoloCompatibilidade(request.protocoloCompatibilidade());
            dispositivoInteligente.setSensorTemperatura(request.sensorTemperatura());
            dispositivoInteligente.setBloqueioManual(request.bloqueioManual());

            dispInteligenteRepository.save(dispositivoInteligente);
        }

        DispositivoEletronico dispositivoAtualizado = dispEletronicoRepository.save(dispositivoExistente);

        return new DispEletronicoCreateResponseDto(dispositivoAtualizado, dispositivoInteligente);
    }

    @Transactional
    public void delete(String id) {
        DispositivoEletronico dispositivo = dispEletronicoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Dispositivo não encontrado com o ID: " + id));

        // Primeiro deleta o dispositivo eletrônico
        dispEletronicoRepository.delete(dispositivo);

        // Depois deleta o dispositivo inteligente associado, se existir
        if (dispositivo.getDispositivoInteligente() != null) {
            dispInteligenteRepository.delete(dispositivo.getDispositivoInteligente());
        }
    }


}
