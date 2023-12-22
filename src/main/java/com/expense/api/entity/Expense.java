package com.expense.api.entity;

import java.util.Date;

public class Expense {

    public Long id;
    private Float amount;
    private Date date;
    private Category category;
    public Expense() {
    }

    public Expense(Float amount, Date date, Category category) {
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public Expense(Long id, Float amount, Date date, Category category) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", expenseCategory=" + category +
                '}';
    }
}
