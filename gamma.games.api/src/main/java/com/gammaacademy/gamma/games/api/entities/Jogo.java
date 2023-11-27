package com.gammaacademy.gamma.games.api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "jogo")
@Entity
@Data
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idJogo;

    @Column(unique = true, length = 100, nullable = false)
    private String nomeJogo;

    @Column(length = 50, nullable = false)
    private String nomeAutor;

    @Column(length = 200, nullable = false)
    private String websiteJogo;

    public void setId_jogo(long id) {
    }
}
