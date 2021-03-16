package com.alkemy.inscripcion.entity;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany
    private List<Schedule> schedules = new ArrayList<>();
    @ManyToMany
    private List<Student> students = new ArrayList<>();


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

    public void addSchedules(Schedule schedule){

        this.schedules.add(schedule);
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
