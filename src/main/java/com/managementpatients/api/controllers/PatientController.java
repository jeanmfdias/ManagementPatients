package com.managementpatients.api.controllers;

import com.managementpatients.api.domains.patients.Patient;
import com.managementpatients.api.domains.patients.PatientService;
import com.managementpatients.api.domains.patients.dto.CreateDataPatientDto;
import com.managementpatients.api.domains.patients.dto.PatientDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    @Transactional
    public ResponseEntity<PatientDto> create(@RequestBody @Valid CreateDataPatientDto dto, UriComponentsBuilder uriBuilder) {
        Patient patient = patientService.save(dto);
        URI uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(new PatientDto(patient));
    }

}
