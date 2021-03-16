package com.alkemy.inscripcion.repository;

import com.alkemy.inscripcion.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public boolean existsByDni(String dni);
    public boolean existsByFile(String file);
}
