package com.gammaacademy.gamma.games.api.repositories;

import com.gammaacademy.gamma.games.api.entities.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {

    List<Historico> findByIdPontuacao(Double idPontuacao);

    List<Historico> findByIdJogo(Double idJogo);

    List<Historico> findByIdUsuario(Double idUsuario);

    List<Historico> findByPontuacao(Double pontuacao);

    List<Historico> findByDatatime(Double datatime);

    List<Historico> findByIdPontuacaoContainingOrIdJogoContainingOrIdUsuarioOrPontuacaoContainingOrDatatimeContaining(double idPontuacao, double idJogo,double idUsuario, double pontuacao, double datatime);
}