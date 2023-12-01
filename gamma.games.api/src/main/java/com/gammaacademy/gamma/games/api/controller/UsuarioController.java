package com.gammaacademy.gamma.games.api.controller;

import com.gammaacademy.gamma.games.api.entities.Usuario;
import com.gammaacademy.gamma.games.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoint para obter todos os usuários
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // Endpoint para obter um usuário pelo ID
    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable long id) {
        return usuarioService.getUsuarioById(id);
    }

    // Endpoint para criar um novo usuário
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.createUsuario(usuario);
    }

    // Endpoint para atualizar um usuário existente pelo ID
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(id, usuario);
    }

    // Endpoint para excluir um usuário pelo ID
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable long id) {
        usuarioService.deleteUsuario(id);
    }
}
