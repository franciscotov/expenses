package com.expense.api.service;

import java.util.List;

public interface BaseService<T> {

    List<T> listAll();

    T getById(Long id);

    int create(T entity);

    T update(T entity);

    void delete(Long id);
}
