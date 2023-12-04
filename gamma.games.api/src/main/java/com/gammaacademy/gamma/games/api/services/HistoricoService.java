package com.gammaacademy.gamma.games.api.services;

import com.gammaacademy.gamma.games.api.entities.Historico;
import com.gammaacademy.gamma.games.api.repositories.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoService {

    private final HistoricoRepository historicoRepository;

    @Autowired
    public HistoricoService(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public List<Historico> getAllHistoricos() {
        return historicoRepository.findAll();
    }

    public Historico getHistoricoById(long id) {
        return historicoRepository.findById(id).orElse(null);
    }

    public Historico createHistorico(Historico historico) {
        return historicoRepository.save(historico);
    }

    public Historico updateHistorico(long id, Historico historico) {
        if (historicoRepository.existsById(id)) {
            return historicoRepository.save(historico);
        }
        return null;
    }
}
