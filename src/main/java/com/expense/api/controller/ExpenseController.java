package com.expense.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("api/v1/expense")
public class ExpenseController {

    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body("responses");
    }


}
