package com.managementpatients.api.domains.schedule.dto;

import jakarta.validation.constraints.NotBlank;

public record CancelDataScheduleDto(@NotBlank Long scheduleId, @NotBlank String cancelReason) {
}
