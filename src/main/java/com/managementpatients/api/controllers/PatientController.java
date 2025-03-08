package com.managementpatients.api.controllers;

import com.managementpatients.api.domains.patients.Patient;
import com.managementpatients.api.domains.patients.PatientService;
import com.managementpatients.api.domains.patients.dto.CreateDataPatientDto;
import com.managementpatients.api.domains.patients.dto.PatientDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("patients")
@SecurityRequirement(name = "bearer-key")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    @Transactional
    public ResponseEntity<PatientDto> create(@RequestBody @Valid CreateDataPatientDto dto,
                                             UriComponentsBuilder uriBuilder) {
        Patient patient = patientService.save(dto);
        URI uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(new PatientDto(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientDto>> listAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = this.patientService.listAllPagination(pagination).map(PatientDto::new);
        return ResponseEntity.ok(page);
    }

}
