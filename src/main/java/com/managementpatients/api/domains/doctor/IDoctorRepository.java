package com.managementpatients.api.domains.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

    Page<Doctor> findAllByDeletedAtIsNull(Pageable pagination);

    @Query("""
            SELECT d FROM Doctor d
            WHERE d.deletedAt IS NULL
            AND d.specialty = :specialty
            AND d.id NOT IN (
                SELECT s.id FROM Schedule s
                WHERE s.date = :date
            )
            ORDER BY RAND()
            LIMIT 1
            """)
    Doctor chooseRandomDoctorIsDateFree(Specialty specialty, LocalDateTime date);

}
