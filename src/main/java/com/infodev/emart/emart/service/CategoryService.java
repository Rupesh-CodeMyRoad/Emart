package com.infodev.emart.emart.service;

import com.infodev.emart.emart.model.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> saveCategories(List<Category> categories);
    List<Category> getCategories();
    Category getCategoryById(Integer id);
    Category updateCategory(Category category);
    void deleteCategoryByIDd(Integer id);
}
