package com.gammaacademy.gamma.games.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "jogo")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 100, nullable = false)
    private String nomeJogo;

    @Column(length = 50, nullable = false)
    private String nomeAutor;

    @Column(length = 200, nullable = false)
    private String siteJogo;

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL)
    private Set<Historico> historicos;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
