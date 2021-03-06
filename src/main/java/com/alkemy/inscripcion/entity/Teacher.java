package com.alkemy.inscripcion.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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
    @NotNull
    private boolean active;
    //Relacion Cursos con Profesores
    @JsonIgnoreProperties("teacher")
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();
;
    public Teacher() {
    }

    public Teacher(@NotNull String name, @NotNull String surname, @NotNull String dni,
                   @NotNull boolean active) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.active = active;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
