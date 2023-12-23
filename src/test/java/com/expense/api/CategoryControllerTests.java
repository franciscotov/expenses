package com.expense.api;

import com.expense.api.constants.Constants;
import com.expense.api.controller.CategoryController;
import com.expense.api.controller.ExpenseController;
import com.expense.api.entity.Category;
import com.expense.api.entity.Expense;
import com.expense.api.service.CategoryService;
import com.expense.api.service.ExpenseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class CategoryControllerTests {


    String basePath = "/api/v1/category";
    String getCategoryPath = "/{id}";
    String getCategoriesPath = "/category-list";

    @InjectMocks
    private CategoryController categoryController;
    @MockBean
    private CategoryService categoryService;
    @Autowired
    private MockMvc mockMvc;

    Category categoryObj = new Category("comida");
    List<Category> categories = new ArrayList<>();

    @Test
    /* [getCategory] bad response 400 */
    public void getCategoryBadRequest() throws Exception  {
        lenient().when(categoryService.getById(any(Long.class))).thenThrow();
        mockMvc.perform(get(basePath + getCategoryPath, 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(Constants.CANT_GET_CATEGORY));
    }

    @Test
    /* [getCategory] OK response 200 */
    public void getCategoryOk() throws Exception  {
        lenient().when(categoryService.getById(any(Long.class))).thenReturn(categoryObj);
        mockMvc.perform(get(basePath + getCategoryPath, 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    /* [getCategories] bad response 400 */
    public void getAllCategoriesBadRequest() throws Exception  {
        lenient().when(categoryService.listAll()).thenThrow();
        mockMvc.perform(get(basePath + getCategoriesPath)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(Constants.CANT_GET_CATEGORIES));
    }

    @Test
    /* [getCategories] OK response 200 */
    public void getAllCategoriesOk() throws Exception  {
        lenient().when(categoryService.listAll()).thenReturn(categories);
        mockMvc.perform(get(basePath + getCategoriesPath)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
