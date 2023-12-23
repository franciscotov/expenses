package com.expense.api.repository;

import com.expense.api.entity.Expense;

public interface ExpenseRepository {
    int insertExpense(Expense expense);
}
