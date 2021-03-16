package com.alkemy.inscripcion.service;

import com.alkemy.inscripcion.entity.Teacher;
import com.alkemy.inscripcion.repository.Teacherrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherService {

    @Autowired
    Teacherrepository teacherrepository;

    @Transactional
    public Teacher save(Teacher teacher){

        return teacherrepository.save(teacher);
    }

    @Transactional(readOnly = true)
    public boolean existsDni(String dni){

        return teacherrepository.existsByDni(dni);
    }
}
