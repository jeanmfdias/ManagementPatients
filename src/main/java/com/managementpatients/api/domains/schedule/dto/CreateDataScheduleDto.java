package com.managementpatients.api.domains.schedule.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateDataScheduleDto(@NotNull
                                    Long doctorId,

                                    @NotNull
                                    Long patientId,

                                    @NotNull
                                    @Future
                                    LocalDateTime date) {
}
