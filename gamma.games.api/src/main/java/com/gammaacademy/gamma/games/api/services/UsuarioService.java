package com.gammaacademy.gamma.games.api.services;

import com.gammaacademy.gamma.games.api.entities.Usuario;
import com.gammaacademy.gamma.games.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Retorna todos os usuários
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Retorna um usuário pelo ID
    public Usuario getUsuarioById(long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.orElse(null);
    }

    // Cria um novo usuário
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Atualiza um usuário existente pelo ID
    public Usuario updateUsuario(long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId_usuario(id);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    // Exclui um usuário pelo ID
    public void deleteUsuario(long id) {
        usuarioRepository.deleteById(id);
    }
}
