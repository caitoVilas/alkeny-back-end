package com.alkemy.inscripcion.service;

import com.alkemy.inscripcion.entity.Course;
import com.alkemy.inscripcion.entity.Teacher;
import com.alkemy.inscripcion.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public Optional<Course> verCurso(Long id){

        return courseRepository.findById(id);
    }

    @Transactional
    public Course save(Course course){

        return courseRepository.save(course);
    }

    @Transactional(readOnly = true)
    public Course findByTeacher(long id){

        return courseRepository.findByTeacher_id(id);
    }

}
