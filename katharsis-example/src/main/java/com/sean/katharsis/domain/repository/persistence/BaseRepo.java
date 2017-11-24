package com.sean.katharsis.domain.repository.persistence;

import java.util.List;

/**
 * Created by sean on 23/11/17.
 */
public interface BaseRepo<T>{

    T save(T objToSave);

    T create(T objToCreate);

    T delete(Long objToDelete);

    List<T> findAll();
}
