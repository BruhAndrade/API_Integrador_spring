package com.gammaacademy.gamma.games.api.services;

import com.gammaacademy.gamma.games.api.dto.UsuarioDTO;
import com.gammaacademy.gamma.games.api.entities.Usuario;
import com.gammaacademy.gamma.games.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> getAllUsuariosDTO() {
        return usuarioRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public Usuario findById(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.orElse(null);
    }

    public UsuarioDTO getUsuarioDTOById(long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.map(this::convertToDTO).orElse(null);
    }

    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(usuario);

        // Atualize o ID no objeto UsuarioDTO
        usuarioDTO.setId(savedUsuario.getId());

        return usuarioDTO;
    }



    public UsuarioDTO updateUsuario(long id, UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = convertToEntity(usuarioDTO);
            usuario.setId(id);
            Usuario updatedUsuario = usuarioRepository.save(usuario);
            return convertToDTO(updatedUsuario);
        } else {
            return null;
        }
    }

    public void deleteUsuario(long id) {
        usuarioRepository.deleteById(id);
    }

    private UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNomeUsuario(usuario.getNomeUsuario());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setNickname(usuario.getNickname());
        return usuarioDTO;
    }


    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(usuarioDTO.getNomeUsuario());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setNickname(usuarioDTO.getNickname());
        return usuario;
    }


}
