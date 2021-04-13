package com.alkemy.inscripcion.controller;

import com.alkemy.inscripcion.entity.Schedule;
import com.alkemy.inscripcion.service.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin
public class ScheduleController {

    @Autowired
    SchedulesService schedulesService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Schedule>> getAll(){

        List<Schedule> schedules = schedulesService.viewAll();

        return new ResponseEntity<List<Schedule>>(schedules, HttpStatus.OK);
    }
}
