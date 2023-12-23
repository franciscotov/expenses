package com.expense.api.repository.implementation;

import com.expense.api.constants.Constants;
import com.expense.api.entity.Category;
import com.expense.api.mapper.CategoryRowMapper;
import com.expense.api.repository.CategoryRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private final JdbcTemplate jdbcTemplate;
    private String INSERT_CATEGORY = Constants.INSERT_CATEGORY;
    private String GET_CATEGORY = Constants.GET_CATEGORY;
    private String GET_CATEGORIES = Constants.GET_CATEGORIES;


    public CategoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Category getById(Long id) {
        return jdbcTemplate.queryForObject(
                GET_CATEGORY,
                new CategoryRowMapper(),
                new Object[]{id}
        );
    }

    @Override
    public List<Category> listAll() {
        return jdbcTemplate.query(GET_CATEGORIES, new CategoryRowMapper());
    }

    @Override
    public int create(Category category) {
        return jdbcTemplate.update(INSERT_CATEGORY, category.getName());
    }
}
