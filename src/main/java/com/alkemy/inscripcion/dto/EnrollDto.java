package com.alkemy.inscripcion.dto;

public class EnrollDto {

    private Long id_student;
    private Long id_course;

    public Long getId_student() {
        return id_student;
    }

    public void setId_student(Long id_student) {
        this.id_student = id_student;
    }

    public Long getId_course() {
        return id_course;
    }

    public void setId_course(Long id_course) {
        this.id_course = id_course;
    }
}
