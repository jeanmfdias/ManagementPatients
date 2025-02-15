package com.managementpatients.api.domains.doctor;

import com.managementpatients.api.domains.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private AddressService addressService;

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
}
