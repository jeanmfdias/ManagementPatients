package com.managementpatients.api.domains.schedule;

import com.managementpatients.api.domains.doctor.Doctor;
import com.managementpatients.api.domains.doctor.IDoctorRepository;
import com.managementpatients.api.domains.doctor.Specialty;
import com.managementpatients.api.domains.patients.IPatientRepository;
import com.managementpatients.api.domains.schedule.dto.CancelDataScheduleDto;
import com.managementpatients.api.domains.schedule.dto.CreateDataScheduleDto;
import com.managementpatients.api.domains.schedule.exceptions.ValidationScheduleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IDoctorRepository doctorRepository;

    public Schedule save(CreateDataScheduleDto dataScheduleDto) {
        if (!this.patientRepository.existsById(dataScheduleDto.patientId())) {
            throw new ValidationScheduleException("Patient not found");
        }

        if (dataScheduleDto.doctorId() != null && !this.doctorRepository.existsById(dataScheduleDto.doctorId())) {
            throw new ValidationScheduleException("Doctor not found.");
        }

        var doctor = chooseDoctor(dataScheduleDto);
        var patient = patientRepository.findById(dataScheduleDto.patientId());

        if (doctor != null && patient.isPresent()) {
            Schedule schedule = new Schedule(null, doctor, patient.get(), dataScheduleDto.date(), null);
            scheduleRepository.save(schedule);
            return schedule;
        }
        return null;
    }

    public Schedule cancel(CancelDataScheduleDto dataScheduleDto) {
        if (!this.scheduleRepository.existsById(dataScheduleDto.scheduleId())) {
            throw new ValidationScheduleException("Schedule not found");
        }

        var schedule = this.scheduleRepository.findById(dataScheduleDto.scheduleId());
        if (schedule.isPresent()) {
            schedule.get().setCancelReason(dataScheduleDto.cancelReason());
            this.scheduleRepository.save(schedule.get());
            return schedule.get();
        }
        return null;
    }

    private Doctor chooseDoctor(CreateDataScheduleDto dataScheduleDto) {
        if (dataScheduleDto.doctorId() != null) {
            var doctor = doctorRepository.findById(dataScheduleDto.doctorId());
            if (doctor.isPresent()) {
                return doctor.get();
            }
        }

        if (dataScheduleDto.specialty() != null) {
            return doctorRepository.chooseRandomDoctorIsDateFree(dataScheduleDto.specialty(), dataScheduleDto.date());
        }

        throw new ValidationScheduleException("Speciality not found");
    }

}
