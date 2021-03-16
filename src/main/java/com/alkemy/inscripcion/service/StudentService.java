package com.alkemy.inscripcion.service;

import com.alkemy.inscripcion.entity.Student;
import com.alkemy.inscripcion.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public boolean existsDni(String dni){

        return studentRepository.existsByDni(dni);
    }

    public boolean existFile(String file){

        return studentRepository.existsByFile(file);
    }

    public Student save(Student student){

        return studentRepository.save(student);
    }
}
