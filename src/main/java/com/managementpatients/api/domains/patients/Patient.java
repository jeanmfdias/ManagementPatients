package com.managementpatients.api.domains.patients;

import com.managementpatients.api.domains.address.Address;
import com.managementpatients.api.domains.patients.dto.CreateDataPatientDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private String email;

    private String phone;

    @Embedded
    private Address address;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public Patient(CreateDataPatientDto dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.phone = dto.phone();
        this.cpf = dto.cpf();
        this.address = new Address(dto.address());
        this.createdAt = LocalDateTime.now().toInstant(ZoneOffset.of("-03:00"));
        this.updatedAt = LocalDateTime.now().toInstant(ZoneOffset.of("-03:00"));
    }

}
