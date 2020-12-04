package com.infodev.emart.emart.service;

import com.infodev.emart.emart.model.Subcategory;

import java.util.List;

public interface SubcategoryService {
    Subcategory saveSubcategory(Subcategory subcategory);
    List<Subcategory> saveSubcategories(List<Subcategory> subcategories);
    List<Subcategory> getSubcategories();
    Subcategory getSubcategoryById(Integer id);
    Subcategory updateSubcategory(Subcategory subcategory);
    void deleteSubcategoryById(Integer id);

}
