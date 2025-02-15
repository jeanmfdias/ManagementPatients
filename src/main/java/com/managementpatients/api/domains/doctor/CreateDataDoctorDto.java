package com.managementpatients.api.domains.doctor;

import com.managementpatients.api.domains.address.CreateDataAddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateDataDoctorDto(@NotBlank
                                  String name,

                                  @NotBlank
                                  @Email
                                  String email,

                                  @NotBlank
                                  @Pattern(regexp = "\\d{4,6}")
                                  String crm,

                                  @NotNull
                                  Specialty specialty,

                                  @NotBlank
                                  String phone,

                                  @NotNull
                                  @Valid
                                  CreateDataAddressDto address) {
}
