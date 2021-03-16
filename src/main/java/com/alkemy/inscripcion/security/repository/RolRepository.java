package com.alkemy.inscripcion.security.repository;

import com.alkemy.inscripcion.security.entity.Rol;
import com.alkemy.inscripcion.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository  extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
