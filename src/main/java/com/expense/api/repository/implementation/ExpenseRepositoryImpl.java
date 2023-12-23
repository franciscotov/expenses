package com.expense.api.repository.implementation;

import com.expense.api.constants.Constants;
import com.expense.api.entity.Expense;
import com.expense.api.repository.ExpenseRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;


@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {
    private final JdbcTemplate jdbcTemplate;
    private String INSERT_EXPENSE = Constants.INSERT_EXPENSE;

    public ExpenseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Expense insertExpense(Expense expense) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_EXPENSE, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, expense.getAmount());
            ps.setInt(2, expense.getCategory().getId().intValue());
            ps.setString(3, expense.getDescription());
            return ps;
        }, keyHolder);

        if (rowsAffected > 0) {
            Long userId = Objects.requireNonNull(keyHolder.getKey()).longValue();
            expense.setId(userId);
        }
        return new Expense();
    }
}
