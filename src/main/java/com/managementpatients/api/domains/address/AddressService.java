package com.managementpatients.api.domains.address;

import org.springframework.stereotype.Service;

@Service
public class AddressService {
    public boolean update(Address address, UpdateDataAddressDto dataAddressDto) {
        if (dataAddressDto.addressName() != null && !dataAddressDto.addressName().isEmpty()) {
            address.setAddressName(dataAddressDto.addressName());
        }
        if (dataAddressDto.neighborhood() != null && !dataAddressDto.neighborhood().isEmpty()) {
            address.setNeighborhood(dataAddressDto.neighborhood());
        }
        if (dataAddressDto.zipcode() != null && !dataAddressDto.zipcode().isEmpty()) {
            address.setZipcode(dataAddressDto.zipcode());
        }
        if (dataAddressDto.city() != null && !dataAddressDto.city().isEmpty()) {
            address.setCity(dataAddressDto.city());
        }
        if (dataAddressDto.state() != null && !dataAddressDto.state().isEmpty()) {
            address.setState(dataAddressDto.state());
        }
        if (dataAddressDto.complement() != null && !dataAddressDto.complement().isEmpty()) {
            address.setComplement(dataAddressDto.complement());
        }
        return true;
    }
}
