package com.infodev.emart.emart.controller;

import com.infodev.emart.emart.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.infodev.emart.emart.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getCategorys")
    public List<Category> getCategorys() {
        return categoryService.getCategories();
    }

    @GetMapping("/getCategory/{id}")
    public Category getCategoryById(@PathVariable("id") int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/addCategory")
    public String  addCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return "category added";
    }

    @PutMapping("/updateCategory")
    public String updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
        return "category updated";
    }

    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategoryById(@PathVariable("id") int id) {
        categoryService.deleteCategoryByIDd(id);
        return "Category deleted";
    }

}
