package com.alkemy.inscripcion.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true, length = 8)
    private String dni;
    @NotNull
    @Column(unique = true, length = 20)
    private String file;
    @NotNull
    @Column(length = 50)
    private String name;
    @NotNull
    @Column(length = 50)
    private String surname;

    public Student() {
    }

    public Student(@NotNull String dni, @NotNull String file, @NotNull String name,
                   @NotNull String surname) {
        this.dni = dni;
        this.file = file;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
}
