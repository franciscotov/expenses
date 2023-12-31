package com.expense.api.repository.implementation;

import com.expense.api.constants.Constants;
import com.expense.api.entity.Expense;
import com.expense.api.mapper.ExpenseRowMapper;
import com.expense.api.repository.ExpenseRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {
    private final JdbcTemplate jdbcTemplate;
    private String INSERT_EXPENSE = Constants.INSERT_EXPENSE;
    private String GET_EXPENSE = Constants.GET_EXPENSE;
    private String GET_ALL_EXPENSES = Constants.GET_ALL_EXPENSES;
    private String DELETE_EXPENSE_BY_ID = Constants.DELETE_EXPENSE_BY_ID;
    private String UPDATE_EXPENSE = Constants.UPDATE_EXPENSE;

    public ExpenseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(Expense expense) {
        return jdbcTemplate.update(INSERT_EXPENSE, expense.getAmount(), expense.getCategoryId(), expense.getDescription());
    }

    @Override
    public Expense getById(Long id) {
        return jdbcTemplate.queryForObject(
                GET_EXPENSE,
                new ExpenseRowMapper(),
                new Object[]{id}
        );
    }

    @Override
    public List<Expense> listAll() {
        return jdbcTemplate.query(GET_ALL_EXPENSES, new ExpenseRowMapper());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE_EXPENSE_BY_ID, id);
    }

    @Override
    public Expense update(Expense expense) {
        jdbcTemplate.update(UPDATE_EXPENSE, expense.getAmount(), expense.getCategoryId(), expense.getDescription(), expense.getId());
        return this.getById(expense.getId());
    }
}
