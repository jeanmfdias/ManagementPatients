package com.managementpatients.api.domains.schedule.validations;

import com.managementpatients.api.domains.schedule.dto.CreateDataScheduleDto;
import com.managementpatients.api.domains.schedule.exceptions.ValidationScheduleException;

import java.time.DayOfWeek;

public class WorkTimeValidator {

    public void valid(CreateDataScheduleDto dataScheduleDto) {
        var date = dataScheduleDto.date();
        var isSunday = date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeOpenTime = date.getHour() < 7;
        var afterCloseTime = date.getHour() > 18;

        if (isSunday || beforeOpenTime || afterCloseTime) {
            throw new ValidationScheduleException("Schedule date out of work time");
        }
    }

}
