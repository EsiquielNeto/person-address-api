package com.project.personaddress.controllers;

import com.project.personaddress.domain.model.Person;
import com.project.personaddress.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<Page<Person>> findAll(Pageable pageable) {
        return ResponseEntity.ok(personService.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody @Valid Person model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(model));
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody @Valid Person model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.update(model, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
