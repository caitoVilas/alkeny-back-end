package com.alkemy.inscripcion.controller;

import com.alkemy.inscripcion.dto.CourseDto;
import com.alkemy.inscripcion.entity.Course;
import com.alkemy.inscripcion.entity.Schedule;
import com.alkemy.inscripcion.service.CourseService;
import com.alkemy.inscripcion.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/course")
@CrossOrigin
public class CourseController {

    @Autowired
    CourseService courseService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> nuevo(@Valid @RequestBody CourseDto course, BindingResult
                                   result){

        if (result.hasErrors())
            return new ResponseEntity(new Mensaje("Error en los datos"),
                    HttpStatus.BAD_REQUEST);

        Course newCourse = new Course(course.getName(),course.getMax(),true);
        newCourse.setTeacher(course.getTeacher());
        Set<Schedule> schedules = new HashSet<>();
        course.getSchedules().stream().forEach(sch -> {
            schedules.add(sch);
        });

        newCourse.setSchedules(schedules);

        courseService.save(newCourse);


        return new ResponseEntity(new Mensaje("Curso Creado!"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @GetMapping("/{id}")
    public ResponseEntity<Course> verCurso(@PathVariable("id") Long id){

        Course course = courseService.verCurso(id).orElse(null);

        return new ResponseEntity<Course>(course,HttpStatus.OK);
    }

}
