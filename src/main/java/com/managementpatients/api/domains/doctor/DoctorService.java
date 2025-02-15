package com.managementpatients.api.domains.doctor;

import com.managementpatients.api.domains.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DoctorService {
    @Autowired
    private AddressService addressService;

    @Autowired
    private IDoctorRepository doctorRepository;

    public boolean update(Doctor doctor, UpdateDataDoctorDto dataDoctorDto) {
        if (dataDoctorDto.name() != null && !dataDoctorDto.name().isEmpty()) {
            doctor.setName(dataDoctorDto.name());
        }
        if (dataDoctorDto.phone() != null && !dataDoctorDto.phone().isEmpty()) {
            doctor.setPhone(dataDoctorDto.phone());
        }
        if (dataDoctorDto.addressDto() != null) {
            addressService.update(doctor.getAddress(), dataDoctorDto.addressDto());
        }
        return true;
    }

    public boolean delete(Long id) {
        Doctor doctor = doctorRepository.getReferenceById(id);
        doctor.setDeletedAt(LocalDateTime.now());
        return true;
    }
}
