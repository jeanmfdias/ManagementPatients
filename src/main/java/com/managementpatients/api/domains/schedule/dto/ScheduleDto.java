package com.managementpatients.api.domains.schedule.dto;

import com.managementpatients.api.domains.doctor.DataDoctorDto;
import com.managementpatients.api.domains.patients.dto.PatientDto;
import com.managementpatients.api.domains.schedule.Schedule;

import java.time.LocalDateTime;

public record ScheduleDto(Long id, DataDoctorDto doctor, PatientDto patient, LocalDateTime date) {

    public ScheduleDto(Schedule schedule) {
        this(schedule.getId(),
                new DataDoctorDto(schedule.getDoctor()),
                new PatientDto(schedule.getPatient()),
                schedule.getDate());
    }

}
