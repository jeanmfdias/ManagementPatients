package com.managementpatients.api.domains.doctor;

import com.managementpatients.api.domains.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Doctor(CreateDataDoctorDto dto) {
        this.name = dto.name();
        this.crm = dto.crm();
        this.email = dto.email();
        this.phone = dto.phone();
        this.specialty = dto.specialty();
        this.address = new Address(dto.address());
    }
}
