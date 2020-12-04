package com.infodev.emart.emart.controller;


import com.infodev.emart.emart.model.Category;
import com.infodev.emart.emart.model.Subcategory;
import com.infodev.emart.emart.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.infodev.emart.emart.service.SubcategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class SubcategoryController {

    @Autowired
    SubcategoryService subcategoryService;

    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping("/getSubcategorys")
    public List<Subcategory> getSubcategorys() {
        return subcategoryService.getSubcategories();
    }

    @GetMapping("/getSubcategory/{id}")
    public Subcategory getSubcategoryById(@PathVariable("id") int id) {
        return subcategoryService.getSubcategoryById(id);
    }

    @PutMapping("/updateSubcategory")
    public String updateSubcategory(@RequestBody Subcategory subcategory) {
        subcategoryService.updateSubcategory(subcategory);
        return "subcategory updated";
    }

    @PostMapping("/addSubcategory/{categoryId}")
    public String addSubcategory(@RequestBody Subcategory subcategory, @PathVariable("categoryId") int categoryId) {
        Optional<Category> category = categoryRepo.findById(categoryId);
        if (category.isPresent()) {
            subcategory.setCategory(category.get());
            subcategoryService.saveSubcategory(subcategory);
            return "Subcategory added";
        } else
            return "Category Not Found,So Subcategory Cannot be Added";
    }

    @DeleteMapping("/deleteSubcategory/{subcategoryId}")
    public String deleteSubcategory(@PathVariable("subcategoryId") int subcategoryId) {
        subcategoryService.deleteSubcategoryById(subcategoryId);
        return "Subcategory deleted";
    }

}
