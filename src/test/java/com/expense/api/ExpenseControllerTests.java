package com.expense.api;

import com.expense.api.constants.Constants;
import com.expense.api.controller.ExpenseController;
import com.expense.api.entity.Expense;
import com.expense.api.repository.ExpenseRepository;
import com.expense.api.service.ExpenseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.lenient;
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ExpenseControllerTests {

    String basePath = "/api/v1/expenses";
    String getExpensePath = "/{id}";
    String getExpensesPath = "/expense-list";

    @InjectMocks
    private ExpenseController expenseController;
    @MockBean
    private ExpenseService expenseService;
    @Autowired
    private MockMvc mockMvc;

    Expense expenseObj = new Expense(100F, 1L,"ultimo gasto de diciembre");
    List<Expense> expenses = new ArrayList<>();

    @Test
    /* [getExpense] OK response 400 */
    public void getExpenseBadRequest() throws Exception  {
        lenient().when(expenseService.getById(any(Long.class))).thenThrow();
        mockMvc.perform(get(basePath + getExpensePath, 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(Constants.CANT_GET_EXPENSE));
    }

    @Test
    /* [getExpense] OK response 200 */
    public void getExpenseOk() throws Exception  {
        lenient().when(expenseService.getById(any(Long.class))).thenReturn(expenseObj);
        mockMvc.perform(get(basePath + getExpensePath, 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    /* [getExpense] OK response 400 */
    public void getAllExpensesBadRequest() throws Exception  {
        lenient().when(expenseService.listAll()).thenThrow();
        mockMvc.perform(get(basePath + getExpensesPath)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(Constants.CANT_GET_EXPENSES));
    }

    @Test
    /* [getExpense] OK response 200 */
    public void getAllExpensesOk() throws Exception  {
        lenient().when(expenseService.listAll()).thenReturn(expenses);
        mockMvc.perform(get(basePath + getExpensesPath)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
