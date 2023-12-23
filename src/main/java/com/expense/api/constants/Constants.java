package com.expense.api.constants;

public class Constants {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SALARY = "salary";
    public static final String DB_NAME_EXPENSE = "expense";
    public static final String DB_NAME_CATEGORY = "category";
    public static final String INSERT_EXPENSE = "INSERT INTO " + DB_NAME_EXPENSE +"(amount, category, description) VALUES (?, ?, ?);";
    public static final String GET_EXPENSE = "SELECT * FROM "+ DB_NAME_EXPENSE + " WHERE id = ?;";
    public static final String UPDATE_EXPENSE = "UPDATE " + DB_NAME_EXPENSE + " SET name = ?, salary = ? WHERE id = ?;";
    public static final String DELETE_EXPENSE_BY_ID = "DELETE FROM " + DB_NAME_EXPENSE + " employees WHERE id = ?;";
    public static final String GET_ALL_EXPENSES = "SELECT * FROM "+ DB_NAME_EXPENSE +";";

    public static final String INSERT_CATEGORY = "INSERT INTO " + DB_NAME_CATEGORY +"(name) VALUES (?);";
    public static final String GET_CATEGORY = "SELECT * FROM "+ DB_NAME_CATEGORY + " WHERE id = ?;";
    public static final String GET_CATEGORIES = "SELECT id, name FROM "+ DB_NAME_CATEGORY + " ;";
}
