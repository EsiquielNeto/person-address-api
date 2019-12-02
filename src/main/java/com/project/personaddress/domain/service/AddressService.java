package com.project.personaddress.domain.service;

import com.project.personaddress.domain.model.Address;
import com.project.personaddress.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends AbstractService<Address, Long>{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    protected Class<Address> getEntityClass() {
        return Address.class;
    }
}
