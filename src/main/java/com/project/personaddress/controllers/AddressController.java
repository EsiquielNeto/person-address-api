package com.project.personaddress.controllers;

import com.project.personaddress.domain.model.Address;
import com.project.personaddress.domain.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("person/{personId}/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<Page<Address>> findAll(@PathVariable Long personId, Pageable pageable) {
        return ResponseEntity.ok(addressService.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<Address> findById(@PathVariable Long personId, @PathVariable  Long id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Address> create(@PathVariable Long personId, @RequestBody @Valid Address model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.create(model));
    }

    @PutMapping("{id}")
    public ResponseEntity<Address> update(@PathVariable Long personId, @PathVariable Long id, @RequestBody @Valid Address model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.update(model, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long personId, @PathVariable Long id) {
        addressService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
