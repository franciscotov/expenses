package com.expense.api.controller;

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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo obtener la lista de categorias");
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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo obtener la categoria");
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> createExpense(
            @PathVariable("id") Long id,
            @RequestBody() ExpenseDto expenseDto
    ) {
        Expense expense = new Expense(expenseDto.getAmount(), expenseDto.getCategory(), expenseDto.getDescription());
        try {
            Expense newExpense = expenseService.create(expense);
            return ResponseEntity.status(HttpStatus.OK).body(newExpense);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo crear la categoria");
        }
    }
}
