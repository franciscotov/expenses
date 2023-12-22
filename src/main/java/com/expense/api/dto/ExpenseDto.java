package com.expense.api.dto;

import com.expense.api.entity.Category;

import java.util.Date;

public class ExpenseDto {
    private Float amount;
    private Date date;
    private Category category;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private int counter(){
        return 1;
    }

    @Override
    public String toString() {
        return "Expense{" +
                ", amount=" + amount +
                ", date=" + date +
                ", expenseCategory=" + category +
                '}';
    }
}
