package com.managementpatients.api.domains.doctor;

import com.managementpatients.api.domains.address.CreateDataAddressDto;
import com.managementpatients.api.domains.patients.Patient;
import com.managementpatients.api.domains.patients.dto.CreateDataPatientDto;
import com.managementpatients.api.domains.schedule.Schedule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class IDoctorRepositoryTest {

    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Should return null when have only doctor save and not available on date")
    void chooseRandomDoctorIsDateFreeShouldNull() {
        var nextMondayAt10am = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10,0);
        var doctor = generateDoctor();
        var patient = generatePatient();
        var schedule = generateSchedule(doctor, patient, nextMondayAt10am);

        var doctorFree = doctorRepository.chooseRandomDoctorIsDateFree(Specialty.CARDIOLOGY, nextMondayAt10am);

        assertThat(doctorFree).isNull();
    }

    private Doctor generateDoctor() {
        return em.persistAndFlush(new Doctor(generateDoctorDto()));
    }

    private Patient generatePatient() {
        return em.persistAndFlush(new Patient(generatePatientDto()));
    }

    private Schedule generateSchedule(Doctor doctor, Patient patient, LocalDateTime nextMondayAt10am) {
        return em.persistAndFlush(new Schedule(null, doctor, patient, nextMondayAt10am, null));
    }

    private CreateDataDoctorDto generateDoctorDto() {
        return new CreateDataDoctorDto("Doctor 1",
                "email@domain.com",
                "123456",
                Specialty.CARDIOLOGY,
                "1199992345",
                new CreateDataAddressDto("Address",
                        "Neighborhood",
                        "11111-800",
                        "City",
                        "St",
                        "1234",
                        null));
    }

    private CreateDataPatientDto generatePatientDto() {
        return new CreateDataPatientDto("Patient 1",
                "12345678901",
                "email_patient@domain.com",
                "11909091000",
                new CreateDataAddressDto("Address 1",
                        "Neighborhood",
                        "15000-900",
                        "City",
                        "St",
                        "6789",
                        null));
    }
}