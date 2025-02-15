package com.managementpatients.api.domains.doctor;

public record ListDataDoctorDto(Long id, String name, String email, String crm, Specialty specialty) {
    public ListDataDoctorDto(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
