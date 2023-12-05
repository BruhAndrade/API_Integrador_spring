package com.gammaacademy.gamma.games.api.dto;

import lombok.Data;

@Data
public class JogoDTO {
    private Long id;
    private String nomeJogo;
    private String nomeAutor;
    private String siteJogo;
    public void setId(Long id) {
        this.id = id;
    }
}
