package com.managementpatients.api.controllers;

import com.managementpatients.api.domains.doctor.CreateDataDoctorDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctors")
public class DoctorController {
    @PostMapping
    public String create(@RequestBody CreateDataDoctorDto data) {
        return data.toString();
    }
}
