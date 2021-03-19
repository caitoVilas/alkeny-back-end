package com.alkemy.inscripcion.controller;

import com.alkemy.inscripcion.dto.EnrollDto;
import com.alkemy.inscripcion.entity.Course;
import com.alkemy.inscripcion.entity.Student;
import com.alkemy.inscripcion.service.CourseService;
import com.alkemy.inscripcion.service.StudentService;
import com.alkemy.inscripcion.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;


    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<?> enroll(@RequestBody EnrollDto enrollDto){

        Course course = courseService.verCurso(enrollDto.getId_course()).get();

        Set<Student> alumnos = course.getStudents();

        Student alumno = studentService.getById(enrollDto.getId_student());

        if (alumnos.size() >= course.getMax()){
            return new ResponseEntity(new Mensaje("El Curso no tiene Cupos"),
                    HttpStatus.BAD_REQUEST);
        }


        Set<Course> cursos = alumno.getCourses();
        cursos.add(course);
        alumno.setCourses(cursos);
        studentService.save(alumno);

        return new ResponseEntity(new Mensaje("Te has inscripo a " + course.getName()),
                HttpStatus.OK);
    }
}
