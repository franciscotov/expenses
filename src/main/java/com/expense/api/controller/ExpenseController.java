package com.expense.api.controller;

import com.expense.api.constants.Constants;
import com.expense.api.dto.CategoryDto;
import com.expense.api.dto.ExpenseDto;
import com.expense.api.entity.Category;
import com.expense.api.entity.Expense;
import com.expense.api.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("api/v1/expenses")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/expense-list")
    public ResponseEntity<Object> getAllExpenses() {
        try {
            List<Expense> expenses = expenseService.listAll();
            return ResponseEntity.status(HttpStatus.OK).body(expenses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Constants.CANT_GET_EXPENSES);
        }
    }

//    @ApiOperation("Webservice para eliminar un costo por zona asociado a un profesional.")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getExpense(
            @PathVariable("id") Long id
    ) {
        try {
            Expense expense = expenseService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(expense);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Constants.CANT_GET_EXPENSE);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> createExpense(
            @RequestBody() ExpenseDto expenseDto
    ) {
        Expense expense = new Expense(expenseDto.getAmount(), expenseDto.getCategoryId(), expenseDto.getDescription());
        try {
            expenseService.create(expense);
            return ResponseEntity.status(HttpStatus.OK).body("Se ha creado el gasto con los siguientes atributos" +expenseDto);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo crear el gasto");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExpense(
            @PathVariable("id") Long id
    ) {
        try {
            expenseService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo eliminar el gasto");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateExpense(
            @PathVariable("id") Long id,
            @RequestBody() ExpenseDto expenseDto
    ) {
        try {
            Expense expense = new Expense(id, expenseDto.getAmount(), expenseDto.getCategoryId(), expenseDto.getDescription());
            Expense expenseUpdated = expenseService.update(expense);
            return ResponseEntity.status(HttpStatus.OK).body(expenseUpdated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar el gasto");
        }
    }
}
