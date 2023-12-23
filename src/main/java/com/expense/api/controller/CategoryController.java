package com.expense.api.controller;

import com.expense.api.dto.CategoryDto;
import com.expense.api.dto.ExpenseDto;
import com.expense.api.entity.Category;
import com.expense.api.entity.Expense;
import com.expense.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/category")

public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category-list")
    public ResponseEntity<Object> getAllCategories() {
        try {
            List<Category> categories = categoryService.listAll();
            return ResponseEntity.status(HttpStatus.OK).body(categories);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo obtener la lista de categorias");
        }
    }

    //    @ApiOperation("Webservice para eliminar un costo por zona asociado a un profesional.")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategory(
            @PathVariable("id") Long id
    ) {
        try {
            Category category = categoryService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(category);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo obtener la categoria");
        }

    }

    @PostMapping("/")
    public ResponseEntity<Object> createCategory(
            @RequestBody() CategoryDto categoryDto
    ) {
        Category category = new Category(categoryDto.getName());
        try {
            categoryService.create(category);
            return ResponseEntity.status(HttpStatus.OK).body("Se ha creado la categoria: " + categoryDto.getName());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo crear la categoria");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(
            @PathVariable("id") Long id
    ) {
        try {
            categoryService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo eliminar el categoria");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategory(
            @PathVariable("id") Long id,
            @RequestBody() CategoryDto categoryDto
    ) {
        try {
            Category category = new Category(id, categoryDto.getName());
            Category categoryUpdated = categoryService.update(category);
            return ResponseEntity.status(HttpStatus.OK).body(categoryUpdated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar el categoria");
        }
    }
}
