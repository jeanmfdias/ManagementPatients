package com.managementpatients.api.domains.patients;

import com.managementpatients.api.domains.patients.dto.CreateDataPatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private IPatientRepository patientRepository;

    public Patient save(CreateDataPatientDto dto) {
        Patient patient = new Patient(dto);
        try {
            patientRepository.save(patient);
            return patient;
        } catch (Exception e) {
            throw new RuntimeException("Error on save patient", e);
        }
    }

    public Page<Patient> listAllPagination(Pageable pagination) {
        return this.patientRepository.findAll(pagination);
    }

}
