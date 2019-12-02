package com.project.personaddress.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceInterface<T, ID> {

    Page<T> findAll(Pageable pageable);

    T findById(ID id);

    T create(T model);

    T update(T model, ID id);

    void delete(ID id);
}
