package com.gammaacademy.gamma.games.api.services;

import com.gammaacademy.gamma.games.api.entities.Historico;
import com.gammaacademy.gamma.games.api.repositories.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoService {

    private final HistoricoRepository historicoRepository;

    @Autowired
    public HistoricoService(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    // Retorna todos os historicos
    public List<Historico> getAllHistoricos() {
        return historicoRepository.findAll();
    }

    // Retorna um historico pelo ID
    public Historico getHistoricoById(long id) {
        Optional<Historico> historicoOptional = historicoRepository.findById(id);
        return historicoOptional.orElse(null);
    }

    // Cria um novo historico
    public Historico createHistorico(Historico historico) {
        return historicoRepository.save(historico);
    }

    // Atualiza um historico existente pelo ID
    public Historico updateHistorico(long id, Historico historico) {
        if (historicoRepository.existsById(id)) {
            historico.setId_historico(id);
            return historicoRepository.save(historico);
        }
        return null;
    }

    // Exclui um usuário pelo ID
    public void deleteUsuario(long id) {
        usuarioRepository.deleteById(id);
    }
}
