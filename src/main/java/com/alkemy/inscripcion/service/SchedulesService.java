package com.alkemy.inscripcion.service;

import com.alkemy.inscripcion.entity.Schedule;
import com.alkemy.inscripcion.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchedulesService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Transactional(readOnly = true)
    public List<Schedule> viewAll(){

        return scheduleRepository.findAll();
    }
}
