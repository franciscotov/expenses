package com.expense.api.controller;

import com.expense.api.dto.CategoryDto;
import com.expense.api.entity.Category;
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
            List<Category> expenses = categoryService.listAll();
            return ResponseEntity.status(HttpStatus.OK).body(expenses);
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
            @PathVariable("id") Long id,
            @RequestBody() CategoryDto categoryDto
    ) {
        Category category = new Category(categoryDto.getName());
        try {
            Category newCategory = categoryService.create(category);
            return ResponseEntity.status(HttpStatus.OK).body(newCategory);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo crear la categoria");
        }

    }
}
