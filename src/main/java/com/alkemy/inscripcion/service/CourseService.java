package com.alkemy.inscripcion.service;

import com.alkemy.inscripcion.entity.Course;
import com.alkemy.inscripcion.repository.CoureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {

    @Autowired
    CoureRepository coureRepository;

    @Transactional
    public Course save(Course course){

        return coureRepository.save(course);
    }
}
