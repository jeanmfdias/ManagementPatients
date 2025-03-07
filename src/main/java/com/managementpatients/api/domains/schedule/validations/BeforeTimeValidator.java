package com.managementpatients.api.domains.schedule.validations;

import com.managementpatients.api.domains.schedule.dto.CreateDataScheduleDto;
import com.managementpatients.api.domains.schedule.exceptions.ValidationScheduleException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class BeforeTimeValidator implements ScheduleValidator {

    public void valid(CreateDataScheduleDto createDataScheduleDto) {
        var date = createDataScheduleDto.date();
        var now = LocalDateTime.now();
        var differenceInMinutes = Duration.between(now, date).toMinutes();
        if (differenceInMinutes < 30) {
            throw new ValidationScheduleException("Schedule date is smaller than 30 minutes");
        }
    }

}
