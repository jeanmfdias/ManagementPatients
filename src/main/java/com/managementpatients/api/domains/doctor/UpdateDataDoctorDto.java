package com.managementpatients.api.domains.doctor;

import com.managementpatients.api.domains.address.UpdateDataAddressDto;
import jakarta.validation.constraints.NotNull;

public record UpdateDataDoctorDto(@NotNull
                                  Long id,
                                  String name,
                                  String phone,
                                  UpdateDataAddressDto addressDto) {
}
