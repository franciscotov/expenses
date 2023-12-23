package com.expense.api.service.implementation;

import com.expense.api.entity.Expense;
import com.expense.api.repository.ExpenseRepository;
import com.expense.api.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Override
    public List<Expense> listAll() {
        return null;
    }

    @Override
    public Expense getById(Long id) {
        return null;
    }

    @Override
    public int create(Expense entity) {
        return expenseRepository.insertExpense(entity);
    }

    @Override
    public Expense update(Expense entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
