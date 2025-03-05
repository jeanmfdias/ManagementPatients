package com.managementpatients.api.domains.schedule.dto;

import com.managementpatients.api.domains.doctor.DataDoctorDto;
import com.managementpatients.api.domains.patients.dto.PatientDto;

import java.time.LocalDateTime;

public record ScheduleDto(Long id, DataDoctorDto doctor, PatientDto patient, LocalDateTime date) {
}
