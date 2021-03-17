package com.alkemy.inscripcion.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length = 50)
    private String name;
    //private List<Integer> schedules = new ArrayList<>();
    @NotNull
    private Integer max;
    //relacion Cursos con Alumnos
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
    //Relacion Cursos con Profesores
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    //Relacion con Horarios
    @ManyToMany
    @JoinTable(name = "courses_schedules",
       joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
       inverseJoinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "id"))
    private Set<Schedule> schedules = new HashSet<>();


    public Course() {
    }

    public Course(String name, Integer max) {
        this.name = name;
        this.max = max;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }
}
