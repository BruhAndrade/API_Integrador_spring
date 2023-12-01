package com.gammaacademy.gamma.games.api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "usuario")
@Entity
@Data

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @Column(unique = true, length = 50, nullable = false)
    private String nomeUsuario;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String nickname;

}
