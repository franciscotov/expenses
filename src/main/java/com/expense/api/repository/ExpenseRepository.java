package com.expense.api.repository;

import com.expense.api.entity.Expense;

import java.util.List;

public interface ExpenseRepository {
    int create(Expense expense);

    Expense getById(Long id);
    List<Expense> listAll();
}
