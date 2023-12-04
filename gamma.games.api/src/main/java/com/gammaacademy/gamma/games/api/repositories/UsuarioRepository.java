package com.gammaacademy.gamma.games.api.repositories;

import com.gammaacademy.gamma.games.api.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
