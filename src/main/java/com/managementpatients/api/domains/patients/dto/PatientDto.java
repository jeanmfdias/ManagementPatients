package com.managementpatients.api.domains.patients.dto;

import com.managementpatients.api.domains.address.Address;
import com.managementpatients.api.domains.patients.Patient;

public record PatientDto(Long id, String name, String cpf, String email, String phone, Address address) {
    public PatientDto(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getCpf(), patient.getEmail(), patient.getPhone(), patient.getAddress());
    }
}
