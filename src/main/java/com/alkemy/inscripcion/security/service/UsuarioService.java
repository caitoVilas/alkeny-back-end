package com.alkemy.inscripcion.security.service;

import com.alkemy.inscripcion.security.entity.Usuario;
import com.alkemy.inscripcion.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreusuario(String nombreUsuario){

        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){

        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }


    public void save(Usuario usuario){

        usuarioRepository.save(usuario);
    }


}