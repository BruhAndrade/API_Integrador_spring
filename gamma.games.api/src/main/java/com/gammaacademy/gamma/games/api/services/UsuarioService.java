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

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.orElse(null);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setIdUsuario(id);
            return usuarioRepository.save(usuario);
        } else {
            return null;
        }
    }

    public void deleteUsuario(long id) {
        usuarioRepository.deleteById(id);
    }
}
