package com.infodev.emart.emart.serviceimpl;

import com.infodev.emart.emart.model.Category;
import com.infodev.emart.emart.repo.CategoryRepo;
import com.infodev.emart.emart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> saveCategories(List<Category> categories) {
        return categoryRepo.saveAll(categories);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepo.getOne(id);
    }

    @Override
    public Category updateCategory(Category category) {
        Category oldCategory = categoryRepo.getOne(category.getCategoryId());
        oldCategory.setCategoryName(category.getCategoryName());
        return categoryRepo.save(oldCategory);
    }

    @Override
    public void deleteCategoryByIDd(Integer id) {
        categoryRepo.deleteById(id);
    }
}
