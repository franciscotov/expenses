package com.expense.api.entity;

import java.util.Date;

public class Expense {

    public Long id;
    private Float amount;
    private Category category;

    private String description;
//    @OneToOne
//    @JoinColumn(name="id_tipo_cuenta",referencedColumnName = "id")
//    private TipoCuenta tipoCuenta;
    public Expense() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Expense(Float amount, Category category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public Expense(Long id, Float amount, Category category, String description) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
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

    private int counter(){
        return 1;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", amount=" + amount +
                ", expenseCategory=" + category +
                '}';
    }
}
