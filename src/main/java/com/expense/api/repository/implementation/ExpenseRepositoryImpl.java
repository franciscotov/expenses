package com.expense.api.repository.implementation;

import com.expense.api.constants.Constants;
import com.expense.api.entity.Expense;
import com.expense.api.repository.ExpenseRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {
    private final JdbcTemplate jdbcTemplate;
    private String INSERT_EXPENSE = Constants.INSERT_EXPENSE;

    public ExpenseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertExpense(Expense expense) {
        return jdbcTemplate.update(INSERT_EXPENSE, expense.getAmount(), expense.getCategory(), expense.getDescription());
    }
}
