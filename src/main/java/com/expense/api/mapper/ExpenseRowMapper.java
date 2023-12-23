package com.expense.api.mapper;

import com.expense.api.entity.Category;
import com.expense.api.entity.Expense;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseRowMapper implements RowMapper<Expense> {

    @Override
    public Expense mapRow(ResultSet rs, int rowNum) throws SQLException {
        Expense expense = new Expense();
        expense.setId(rs.getLong("id"));
        expense.setAmount(rs.getFloat("amount"));
        expense.setDescription(rs.getString("description"));
        expense.setCategoryId(rs.getLong("category_id"));
        return expense;
    }
}
