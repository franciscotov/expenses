package com.expense.api.service.implementation;

import com.expense.api.entity.Category;
import com.expense.api.repository.CategoryRepository;
import com.expense.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> listAll() {
        return categoryRepository.listAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Category create(Category entity) {
        return categoryRepository.create(entity);
    }

    @Override
    public Category update(Category entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
