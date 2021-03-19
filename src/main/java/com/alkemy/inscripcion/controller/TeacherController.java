package com.alkemy.inscripcion.controller;

import com.alkemy.inscripcion.entity.Teacher;
import com.alkemy.inscripcion.service.CourseService;
import com.alkemy.inscripcion.service.TeacherService;
import com.alkemy.inscripcion.util.Mensaje;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseService courseService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> nuevo(@Valid @RequestBody Teacher teacher, BindingResult
                                   result){

        if (result.hasErrors())
            return new ResponseEntity(new Mensaje("Error en los datos"),
                    HttpStatus.BAD_REQUEST);
        if (teacherService.existsDni(teacher.getDni()))
            return new ResponseEntity(new Mensaje("El DNI ya esxiste"),
                    HttpStatus.BAD_REQUEST);

        teacherService.save(teacher);
         return new ResponseEntity(new Mensaje("Profesor Creado"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){

        if (courseService.findByTeacher(id) != null){
            return new ResponseEntity(new Mensaje("El Profesor posee Cursos Activos"),
                    HttpStatus.BAD_REQUEST);
        }

         teacherService.delete(id);
         return new ResponseEntity(new Mensaje("Profesor Eliminado"),HttpStatus.OK);
    }
}
