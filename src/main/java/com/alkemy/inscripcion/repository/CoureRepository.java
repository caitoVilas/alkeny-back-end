package com.alkemy.inscripcion.repository;

import com.alkemy.inscripcion.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoureRepository extends JpaRepository<Course, Long> {
}
