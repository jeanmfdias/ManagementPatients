package com.managementpatients.api.controllers;

import com.managementpatients.api.domains.schedule.Schedule;
import com.managementpatients.api.domains.schedule.ScheduleService;
import com.managementpatients.api.domains.schedule.dto.CreateDataScheduleDto;
import com.managementpatients.api.domains.schedule.dto.ScheduleDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    @Transactional
    public ResponseEntity<ScheduleDto> create(@RequestBody @Valid CreateDataScheduleDto dataScheduleDto) {
        Schedule schedule = scheduleService.save(dataScheduleDto);
        return ResponseEntity.ok(new ScheduleDto(schedule));
    }

}
