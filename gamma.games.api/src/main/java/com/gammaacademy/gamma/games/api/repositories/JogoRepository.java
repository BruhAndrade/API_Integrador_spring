package com.gammaacademy.gamma.games.api.repositories;

import com.gammaacademy.gamma.games.api.entities.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    List<Jogo> findByNomeAutor(String nomeAutor);

    List<Jogo> findByNomeJogo(String nomeJogo);

    List<Jogo> findByNomeJogoContainingOrNomeAutorContaining(String nomeJogo, String nomeAutor);
}
