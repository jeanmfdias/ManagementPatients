package com.managementpatients.api.controllers;

import com.managementpatients.api.domains.doctor.CreateDataDoctorDto;
import com.managementpatients.api.domains.doctor.Doctor;
import com.managementpatients.api.domains.doctor.IDoctorRepository;
import com.managementpatients.api.domains.doctor.ListDataDoctorDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {
    @Autowired
    private IDoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public String create(@RequestBody @Valid CreateDataDoctorDto createDto) {
        doctorRepository.save(new Doctor(createDto));
        return "Create with success";
    }

    @GetMapping
    public List<ListDataDoctorDto> listAll() {
        return doctorRepository.findAll()
                .stream()
                .map(ListDataDoctorDto::new)
                .toList();
    }
}
