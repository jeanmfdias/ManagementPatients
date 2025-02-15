package com.managementpatients.api.domains.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name = "address_name")
    private String addressName;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String number;
    private String complement;

    public Address(CreateDataAddressDto dto) {
        this.addressName = dto.addressName();
        this.neighborhood = dto.neighborhood();
        this.zipcode = dto.zipcode();
        this.city = dto.city();
        this.state = dto.state();
        this.number = dto.number();
        this.complement = dto.complement();
    }
}
