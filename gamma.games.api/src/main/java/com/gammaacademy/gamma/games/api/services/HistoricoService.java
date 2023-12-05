package com.gammaacademy.gamma.games.api.services;

import com.gammaacademy.gamma.games.api.dto.HistoricoDTO;
import com.gammaacademy.gamma.games.api.entities.Historico;
import com.gammaacademy.gamma.games.api.repositories.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistoricoService {

    private final HistoricoRepository historicoRepository;

    @Autowired
    public HistoricoService(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public List<HistoricoDTO> getAllHistoricosDTO() {
        return historicoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public HistoricoDTO getHistoricoDTOById(long id) {
        return historicoRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new EmptyResultDataAccessException("Historico not found with id: " + id, 1));
    }

    public HistoricoDTO createHistorico(HistoricoDTO historicoDTO) {
        Historico historico = convertToEntity(historicoDTO);
        Historico savedHistorico = historicoRepository.save(historico);

        HistoricoDTO savedHistoricoDTO = convertToDTO(savedHistorico);
        savedHistoricoDTO.setId(savedHistorico.getId());
        return savedHistoricoDTO;
    }

    public void delete(long id) {
        try {
            historicoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("Historico not found with id: " + id, 1);
        }
    }

    public HistoricoDTO updateHistorico(long id, HistoricoDTO historicoDTO) {
        if (historicoRepository.existsById(id)) {
            Historico historico = convertToEntity(historicoDTO);
            historico.setId(id);
            return convertToDTO(historicoRepository.save(historico));
        }
        throw new EmptyResultDataAccessException("Historico not found with id: " + id, 1);
    }

    private HistoricoDTO convertToDTO(Historico historico) {
        HistoricoDTO historicoDTO = new HistoricoDTO();
        historicoDTO.setId(historico.getId());

        // Verifica se o jogo não é null antes de acessar seus atributos
        if (historico.getJogo() != null) {
            historicoDTO.setIdJogo(historico.getJogo().getId());
            historicoDTO.setNomeJogo(historico.getJogo().getNomeJogo());
        }

        // Verifica se o usuário não é null antes de acessar seus atributos
        if (historico.getUsuario() != null) {
            historicoDTO.setIdUsuario(historico.getUsuario().getId());
            historicoDTO.setNomeUsuario(historico.getUsuario().getNomeUsuario());
        }

        historicoDTO.setPontuacao(historico.getPontuacao());
        return historicoDTO;
    }


    private Historico convertToEntity(HistoricoDTO historicoDTO) {
        Historico historico = new Historico();
        historico.setPontuacao(historicoDTO.getPontuacao());
        return historico;
    }

    public Historico findById(Long id) {
        Optional<Historico> optionalHistorico = historicoRepository.findById(id);
        return optionalHistorico.orElseThrow(() -> new EmptyResultDataAccessException("Historico not found with id: " + id, 1));
    }
}