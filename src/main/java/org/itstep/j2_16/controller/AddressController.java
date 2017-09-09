package org.itstep.j2_16.controller;

import org.itstep.j2_16.entity.Address;
import org.itstep.j2_16.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddress(@PathVariable long id){
        return new ResponseEntity<>(addressService.getById(id), OK);
    }

    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
        return new ResponseEntity<>(addressService.save(address), OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAddresses(@PathVariable long id, @RequestBody Address address) {
        return new ResponseEntity<>(addressService.update(id, address), OK);
    }
}

