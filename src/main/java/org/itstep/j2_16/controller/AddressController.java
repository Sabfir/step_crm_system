package org.itstep.j2_16.controller;

import org.itstep.j2_16.entity.Address;
import org.itstep.j2_16.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OrderBy;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;
    private final Class<Address> addressClass = Address.class;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAddresses() {
        return new ResponseEntity<>(addressService.getAll(), OK);
    }

    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
        return new ResponseEntity<>(addressService.save(address), OK);
    }
}
