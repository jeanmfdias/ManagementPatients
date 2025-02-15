package com.managementpatients.api.domains.address;

public record CreateDataAddressDto(String name,
                                   String neighborhood,
                                   String zipcode,
                                   String city,
                                   String state,
                                   String number,
                                   String complement) {
}
