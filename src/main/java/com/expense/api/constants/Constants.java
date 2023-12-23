package com.expense.api.constants;

public class Constants {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SALARY = "salary";
    public static final String DB_NAME_EXPENSE = "expense";
    public static final String DB_NAME_CATEGORY = "category";
    public static final String INSERT_EXPENSE = "INSERT INTO " + DB_NAME_EXPENSE +"(amount, category_id, description) VALUES (?, ?, ?);";
    public static final String GET_EXPENSE = "SELECT * FROM "+ DB_NAME_EXPENSE + " WHERE id = ?;";
    public static final String UPDATE_EXPENSE = "UPDATE " + DB_NAME_EXPENSE + " SET amount = ?, category_id = ?, description = ? WHERE id = ?;";
    public static final String DELETE_EXPENSE_BY_ID = "DELETE FROM " + DB_NAME_EXPENSE + " WHERE id = ?;";
    public static final String GET_ALL_EXPENSES = "SELECT * FROM "+ DB_NAME_EXPENSE +";";

    public static final String INSERT_CATEGORY = "INSERT INTO " + DB_NAME_CATEGORY +"(name) VALUES (?);";
    public static final String GET_CATEGORY = "SELECT * FROM "+ DB_NAME_CATEGORY + " WHERE id = ?;";
    public static final String GET_CATEGORIES = "SELECT id, name FROM "+ DB_NAME_CATEGORY + " ;";
    public static final String DELETE_CATEGORY_BY_ID = "DELETE FROM " + DB_NAME_CATEGORY + " WHERE id = ?;";
    public static final String UPDATE_CATEGORY = "UPDATE " + DB_NAME_CATEGORY + " SET name = ? WHERE id = ?;";
    public static final String  CANT_GET_EXPENSE = "No se pudo obtener el gasto";
    public static final String  CANT_GET_EXPENSES = "No se pudo obtener la lista de categorias";
    public static final String  EXPENSE_CREATED = "Se ha creado el gasto con los siguientes atributos";
    public static final String  CANT_CREATE_EXPENSE = "No se pudo crear el gasto";
    public static final String  EXPENSE_DELETED = "Eliminado correctamente";
    public static final String  CANT_DELETE_EXPENSE = "No se pudo eliminar el gasto";
    public static final String  CANT_UPDATE_EXPENSE = "No se pudo actualizar el gasto";
    public static final String  CANT_GET_CATEGORIES = "No se pudo obtener la lista de categorias";
    public static final String  CANT_GET_CATEGORY = "No se pudo obtener la categoria";
    public static final String  CATEGORY_CREATED = "Se ha creado la categoria: ";

    public static final String  CANT_CREATE_CATEGORY = "No se pudo crear la categoria";
    public static final String  CATEGORY_DELETED = "Eliminada correctamente";
    public static final String  CANT_DELETE_CATEGORY = "No se pudo eliminar el categoria";
    public static final String  CANT_UPDATE_CATEGORY = "No se pudo actualizar el categoria";
}
