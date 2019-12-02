package com.project.personaddress.domain.service;

import com.project.personaddress.domain.model.Person;
import com.project.personaddress.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends AbstractService<Person, Long>{

    @Autowired
    private PersonRepository personRepository;

    @Override
    JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }

    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }
}
