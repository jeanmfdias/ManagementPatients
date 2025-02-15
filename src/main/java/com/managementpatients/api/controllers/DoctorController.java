package com.managementpatients.api.controllers;

import com.managementpatients.api.domains.doctor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("doctors")
public class DoctorController {
    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    @Transactional
    public ResponseEntity<DataDoctorDto> create(@RequestBody @Valid CreateDataDoctorDto createDto,
                                                UriComponentsBuilder uriBuilder) {
        Doctor doctor = doctorRepository.save(new Doctor(createDto));
        DataDoctorDto dto = new DataDoctorDto(doctor);
        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<DataDoctorDto> listOne(@PathVariable Long id) {
        Doctor doctor = doctorRepository.getReferenceById(id);
        DataDoctorDto dto = new DataDoctorDto(doctor);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ListDataDoctorDto>> listAll(@PageableDefault(size = 10, sort = {"name"})
                                           Pageable pagination) {
        var page = doctorRepository.findAllByDeletedAtIsNull(pagination)
                .map(ListDataDoctorDto::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataDoctorDto> update(@RequestBody @Valid UpdateDataDoctorDto updateDto) {
        Doctor doctor = doctorRepository.getReferenceById(updateDto.id());
        doctorService.update(doctor, updateDto);
        DataDoctorDto dto = new DataDoctorDto(doctor);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
//        doctorRepository.deleteById(id);
        doctorService.delete(id);
        return ResponseEntity.noContent().build(); // status code 204
    }
}
