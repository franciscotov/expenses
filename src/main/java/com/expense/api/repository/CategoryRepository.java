package com.expense.api.repository;

import com.expense.api.entity.Category;

import java.util.List;

public interface CategoryRepository {
    int create(Category category);
    Category getById(Long id);
    List<Category> listAll();
    void delete(Long id);
    Category update(Category expense);
}
