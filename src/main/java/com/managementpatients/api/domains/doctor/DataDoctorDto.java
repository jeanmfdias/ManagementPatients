package com.managementpatients.api.domains.doctor;

import com.managementpatients.api.domains.address.Address;

public record DataDoctorDto(Long id, String name, String email, String crm, String phone, Specialty specialty, Address address) {
    public DataDoctorDto(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhone(), doctor.getSpecialty(), doctor.getAddress());
    }
}
