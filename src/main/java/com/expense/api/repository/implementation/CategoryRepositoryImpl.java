package com.expense.api.repository.implementation;

import com.expense.api.constants.Constants;
import com.expense.api.entity.Category;
import com.expense.api.mapper.CategoryRowMapper;
import com.expense.api.repository.CategoryRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

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
    public Category create(Category expense) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_CATEGORY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, expense.getName());
            return ps;
        }, keyHolder);

        if (rowsAffected > 0) {
            Long userId = Objects.requireNonNull(keyHolder.getKey()).longValue();
            expense.setId(userId);
        }
        return new Category();
    }
}
