package com.managementpatients.api.domains.address;

import jakarta.validation.constraints.Pattern;

public record UpdateDataAddressDto(String addressName,
                                   String neighborhood,

                                   @Pattern(regexp = "\\d{8}")
                                   String zipcode,
                                   String city,
                                   String state,
                                   String number,
                                   String complement) {
}
