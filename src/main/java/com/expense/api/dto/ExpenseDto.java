package com.expense.api.dto;

import com.expense.api.entity.Category;

import java.util.Date;

public class ExpenseDto {
    private Float amount;
    private Long categoryId;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "ExpenseDto{" +
                "amount=" + amount +
                ", categoryId=" + categoryId +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    private int counter(){
        return 1;
    }


}
