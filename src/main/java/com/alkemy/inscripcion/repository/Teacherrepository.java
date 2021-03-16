package com.alkemy.inscripcion.repository;

import com.alkemy.inscripcion.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Teacherrepository extends JpaRepository<Teacher, Long> {

    boolean existsByDni(String dni);
}
