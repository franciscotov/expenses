package com.expense.api.dto;

import com.expense.api.entity.Category;

import java.util.Date;

public class ExpenseDto {
    private Float amount;
    private Category category;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    private int counter(){
        return 1;
    }

    @Override
    public String toString() {
        return "Expense{" +
                ", amount=" + amount +
                ", expenseCategory=" + category +
                '}';
    }
}
