package com.managementpatients.api.domains.schedule.validations;

import com.managementpatients.api.domains.schedule.dto.CreateDataScheduleDto;

public interface ScheduleValidator {
    public void valid(CreateDataScheduleDto dataScheduleDto);
}
