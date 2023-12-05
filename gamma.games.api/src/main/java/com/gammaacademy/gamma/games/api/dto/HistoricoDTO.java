package com.gammaacademy.gamma.games.api.dto;

import lombok.Data;

@Data
public class HistoricoDTO {
    private Long id;
    private Long idJogo;
    private String nomeJogo;
    private Long idUsuario;
    private String nomeUsuario;
    private double pontuacao;
}
