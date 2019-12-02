package com.project.personaddress.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractService<T, ID>  implements ServiceInterface<T, ID> {

    abstract JpaRepository<T, ID> getRepository();
    protected abstract Class<T> getEntityClass();

    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public T findById(ID id) {
        getRepository().existsById(id);
        return getRepository().getOne(id);
    }

    public T create(T model) {
        return getRepository().saveAndFlush(model);
    }

    public T update(T model, ID id) {
        T savedModel = this.findById(id);

        BeanUtils.copyProperties(model, savedModel, "id");

        return getRepository().saveAndFlush(savedModel);
    }

    public void delete(ID id) {
        getRepository().existsById(id);
        getRepository().deleteById(id);
    }

}
