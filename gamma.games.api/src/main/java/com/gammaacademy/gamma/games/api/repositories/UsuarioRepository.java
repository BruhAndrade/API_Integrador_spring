package com.gammaacademy.gamma.games.api.repositories;

import com.gammaacademy.gamma.games.api.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNome(String nomeUsuario);

    List<Usuario> findByEmailUsuario(String emailUsuario);

    List<Usuario> findByNicknameUsuario(String nicknameUsuario);

    List<Usuario> findByNomeUsuarioContainingOrEmailUsuarioContainingOrNicknameUsuario(String nomeUsuario, String emailUsuario, String nicknameUsuario);
}