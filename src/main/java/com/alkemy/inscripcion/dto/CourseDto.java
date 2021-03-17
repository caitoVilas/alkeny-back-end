package com.alkemy.inscripcion.dto;

import com.alkemy.inscripcion.entity.Schedule;
import com.alkemy.inscripcion.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public class CourseDto {

    private String name;
    private int max;
    private Teacher teacher;
    private List<Schedule> schedules = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
