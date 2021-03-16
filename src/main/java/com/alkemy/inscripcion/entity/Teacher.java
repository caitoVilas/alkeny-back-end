package com.alkemy.inscripcion.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length = 50)
    private String name;
    @NotNull
    @Column(length = 50)
    private String surname;
    @NotNull
    @Column(unique = true, length = 8)
    private String dni;
    @OneToMany
    private List<Course> courses = new ArrayList<>();
;
    public Teacher() {
    }

    public Teacher(@NotNull String name, @NotNull String surname, @NotNull String dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
