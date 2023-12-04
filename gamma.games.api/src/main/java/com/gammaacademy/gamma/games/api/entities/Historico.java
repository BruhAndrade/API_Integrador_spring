package com.gammaacademy.gamma.games.api.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHistorico;

    @ManyToOne
    @JoinColumn(name = "idJogo")
    private Jogo jogo;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private double pontuacao;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}

