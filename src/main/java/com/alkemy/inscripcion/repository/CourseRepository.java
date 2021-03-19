package com.alkemy.inscripcion.repository;

import com.alkemy.inscripcion.entity.Course;
import com.alkemy.inscripcion.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

   public Course findByTeacher_id(Long id);
}
