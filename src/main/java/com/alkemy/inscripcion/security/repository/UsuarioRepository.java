package com.alkemy.inscripcion.security.repository;


import com.alkemy.inscripcion.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNombreUsuario(String nommbreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
}