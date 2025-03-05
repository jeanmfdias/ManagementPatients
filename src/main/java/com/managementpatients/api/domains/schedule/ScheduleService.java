package com.managementpatients.api.domains.schedule;

import com.managementpatients.api.domains.doctor.Doctor;
import com.managementpatients.api.domains.doctor.IDoctorRepository;
import com.managementpatients.api.domains.patients.IPatientRepository;
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

        var doctor = chooseDoctor(dataScheduleDto.doctorId());
        var patient = patientRepository.findById(dataScheduleDto.patientId());

        if (doctor != null && patient.isPresent()) {
            Schedule schedule = new Schedule(null, doctor, patient.get(), dataScheduleDto.date());
            scheduleRepository.save(schedule);
            return schedule;
        }
        return null;
    }

    private Doctor chooseDoctor(Long doctorId) {
        if (doctorId != null) {
            var doctor = doctorRepository.findById(doctorId);
            if (doctor.isPresent()) {
                return doctor.get();
            }
        }

        return null;
    }

}
