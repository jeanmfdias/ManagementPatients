package com.managementpatients.api.controllers;

import com.managementpatients.api.domains.doctor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("doctors")
public class DoctorController {
    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    @Transactional
    public String create(@RequestBody @Valid CreateDataDoctorDto createDto) {
        doctorRepository.save(new Doctor(createDto));
        return "Create with success";
    }

    @GetMapping
    public Page<ListDataDoctorDto> listAll(@PageableDefault(size = 10, sort = {"name"})
                                           Pageable pagination) {
        return doctorRepository.findAll(pagination)
                .map(ListDataDoctorDto::new);
    }

    @PutMapping
    @Transactional
    public String update(@RequestBody @Valid UpdateDataDoctorDto updateDto) {
        Doctor doctor = doctorRepository.getReferenceById(updateDto.id());
        doctorService.update(doctor, updateDto);
        return "Update with success";
    }
}
