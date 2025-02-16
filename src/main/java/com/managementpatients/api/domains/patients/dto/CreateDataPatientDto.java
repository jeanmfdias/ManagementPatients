package com.managementpatients.api.domains.patients.dto;

import com.managementpatients.api.domains.address.CreateDataAddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateDataPatientDto(@NotBlank
                                   String name,

                                   @NotBlank
//                                   @Pattern(regexp = "\\d{14}")
                                   String cpf,

                                   @NotBlank
                                   @Email
                                   String email,

//                                   @Pattern(regexp = "\\d{15}")
                                   String phone,

                                   @NotNull
                                   @Valid
                                   CreateDataAddressDto address) {
}
