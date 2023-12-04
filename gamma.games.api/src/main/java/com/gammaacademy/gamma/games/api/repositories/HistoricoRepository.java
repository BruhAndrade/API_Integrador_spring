package com.gammaacademy.gamma.games.api.repositories;

import com.gammaacademy.gamma.games.api.entities.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {

    List<Historico> findByPontuacao(Double pontuacao);

    List<Historico> findByJogo_IdJogo(Long idJogo); // Alterado para corresponder ao atributo na classe Historico

    List<Historico> findByUsuario_IdUsuario(Long idUsuario); // Alterado para corresponder ao atributo na classe Historico

    // Adicione outros métodos conforme necessário

}
