package com.gammaacademy.gamma.games.api.services;

import com.gammaacademy.gamma.games.api.entities.Jogo;
import com.gammaacademy.gamma.games.api.repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> getAllJogos() {
        return jogoRepository.findAll();
    }

    public Jogo getJogoById(long id) {
        return jogoRepository.findById(id).orElse(null);
    }

    public Jogo createJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public Jogo updateJogo(long id, Jogo jogo) {
        if (jogoRepository.existsById(id)) {
            // No need to set the ID explicitly; Spring Data JPA handles it
            return jogoRepository.save(jogo);
        }
        return null;
    }


    public void deleteJogo(long id) {
        jogoRepository.deleteById(id);
    }
}
