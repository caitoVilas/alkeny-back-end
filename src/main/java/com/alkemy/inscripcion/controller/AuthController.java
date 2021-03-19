package com.alkemy.inscripcion.controller;


import com.alkemy.inscripcion.entity.Student;
import com.alkemy.inscripcion.security.dto.JwtDto;
import com.alkemy.inscripcion.security.dto.LoginUsuario;
import com.alkemy.inscripcion.security.dto.NuevoUsuario;
import com.alkemy.inscripcion.security.entity.Rol;
import com.alkemy.inscripcion.security.entity.Usuario;
import com.alkemy.inscripcion.security.enums.RolNombre;
import com.alkemy.inscripcion.security.jwt.JwtProvider;
import com.alkemy.inscripcion.security.service.RolService;
import com.alkemy.inscripcion.security.service.UsuarioService;
import com.alkemy.inscripcion.service.StudentService;
import com.alkemy.inscripcion.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    StudentService studentService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult
            bindingResult){

        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new Mensaje("Campos mal puestos"),
                    HttpStatus.BAD_REQUEST);

        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("El Legajo ya existe"),
                    HttpStatus.BAD_REQUEST);


        Usuario usuario = new Usuario(nuevoUsuario.getNombreUsuario(),
                passwordEncoder.encode(nuevoUsuario.getPassword()));

        if (nuevoUsuario.getTipo().equals("ALUMNO")){
            Set<Rol> roles = new HashSet<>();
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
            usuario.setRoles(roles);

            Student newStudent = new Student(nuevoUsuario.getPassword(),
                    nuevoUsuario.getNombreUsuario(),nuevoUsuario.getName(),
                    nuevoUsuario.getSurname());
            studentService.save(newStudent);

        }else {
            Set<Rol> roles = new HashSet<>();
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
            usuario.setRoles(roles);
        }

        usuarioService.save(usuario);

        return new ResponseEntity(new Mensaje("Usuario Creado"),HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario,
                                        BindingResult bindingResult){

        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),
                        loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(),userDetails.getAuthorities());
        return new ResponseEntity(jwtDto,HttpStatus.OK);

    }
}