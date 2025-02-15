package com.managementpatients.api.domains.doctor;

import com.managementpatients.api.domains.address.CreateDataAddressDto;

public record CreateDataDoctorDto(String name,
                                  String email,
                                  String crm,
                                  Specialty specialty,
                                  String phone,
                                  CreateDataAddressDto address) {
}
