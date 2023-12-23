package com.expense.api.repository;

import com.expense.api.entity.Category;

import java.util.List;

public interface CategoryRepository {
    Category create(Category category);
    Category getById(Long id);
    List<Category> listAll();
}
