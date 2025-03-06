package com.managementpatients.api.domains.schedule.dto;

import com.managementpatients.api.domains.doctor.Specialty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateDataScheduleDto(Long doctorId,

                                    @NotNull
                                    Long patientId,

                                    @NotNull
                                    @Future
                                    LocalDateTime date,

                                    Specialty specialty) {
}
