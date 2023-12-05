package com.gammaacademy.gamma.games.api.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nomeUsuario;
    private String email;
    private String nickname;
}
