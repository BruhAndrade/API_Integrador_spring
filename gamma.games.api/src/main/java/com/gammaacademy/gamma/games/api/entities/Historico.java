package com.gammaacademy.gamma.games.api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "Historico")
@Entity
@Data
public class Historico{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHistorico;
    
    @Column(unique = true, nullable = false)
    private Double idPontuacao;

    @Column(unique = true, nullable = false)
    private Double idJogo;

    @Column(unique = true, nullable = false)
    private Double idUsuario;

    @Column(unique = true, nullable = false)
    private Double pontuacao;

    @Column(nullable = false)
    private Double datatime;

}
