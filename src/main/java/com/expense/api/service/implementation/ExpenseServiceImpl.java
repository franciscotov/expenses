package com.expense.api.service.implementation;

import com.expense.api.entity.Expense;
import com.expense.api.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Override
    public List<Expense> listAll() {
        return null;
    }

    @Override
    public Expense getById(Long id) {
        return null;
    }

    @Override
    public Expense create(Expense entity) {
        return null;
    }

    @Override
    public Expense update(Expense entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
